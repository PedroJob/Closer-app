package closer.registration;

import closer.models.Groups;
import closer.models.User;
import closer.utils.HashMd5;
import closer.utils.HibernateUtil;
import jakarta.persistence.*;
import java.sql.SQLException;
import org.hibernate.*;

import java.util.List;

public class GenericDao {
    public void handleException(Exception ex) {
        if (ex instanceof SQLException) {
            printSQLException((SQLException) ex);
        } else {
            ex.printStackTrace();
        }
    }

    public void printSQLException(SQLException ex) {
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
