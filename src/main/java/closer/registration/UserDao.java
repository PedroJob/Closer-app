package closer.registration;

import closer.models.User;
import closer.utils.HashMd5;
import closer.utils.HibernateUtil;
import jakarta.persistence.*;
import java.sql.SQLException;

import org.hibernate.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserDao {

    public List<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").getResultList();
        t.commit();
        return users;
    }

    public User getByUsername(String username) {
        User user = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();

            Query query = session.createQuery("FROM User WHERE username= :username").setParameter("username", username);
            user = (User) query.getSingleResult();
            t.commit();

            return user;
        } catch(HibernateException e) {
            handleException(e);
        }

        return user;
    }

    public User createUser(String email, String username, String password) {
        Session session = null; // Declare session outside the try block
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();

            User u = new User();
            u.setEmail(email);
            u.setUsername(username);

            String hash = HashMd5.hash(password);
            u.setPassword(hash);
            session.save(u);

            t.commit();
            return u;
        } catch (HibernateException e) {
            handleException(e);
            return null; // Or handle the exception according to your application's logic
        } finally {
            if (session != null && session.isOpen()) {
                session.close(); // Close the session in the finally block
            }
        }
    }


    private void handleException(Exception ex) {
        if (ex instanceof SQLException) {
            printSQLException((SQLException) ex);
        } else {
            ex.printStackTrace();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
