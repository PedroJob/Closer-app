package closer.registration;

import closer.models.User;
import closer.utils.HashMd5;
import closer.utils.HibernateUtil;
import jakarta.persistence.*;
import java.sql.SQLException;
import org.hibernate.*;

import java.util.List;

public class UserDao extends GenericDao{

    public List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            List<User> allUsers = session.createQuery("FROM User", User.class).getResultList();
            t.commit();
            return allUsers;
        } catch (HibernateException e) {
            handleException(e);
            return null;
        }
    }

    public User getByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            Query query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();
            t.commit();
            return user;
        } catch (HibernateException e) {
            handleException(e);
            return null;
        }
    }

    public User createUser(String email, String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();

            User u = new User();
            u.setEmail(email);
            u.setUsername(username);

            String hash = HashMd5.hash(password);
            u.setPassword(hash);
            session.persist(u);

            t.commit();
            return u;
        } catch (HibernateException e) {
            handleException(e);
            return null;
        }
    }

}
