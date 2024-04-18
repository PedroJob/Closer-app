package closer.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import closer.models.User;

public class UserDao {

    public int registerUser(User user ) {
        String INSERT_USER_SQL = "INSERT INTO users" + "(UserName, UserEmail, UserPassWordHash, UserProfilePic) VALUES" + "(?, ?, ?, ?);";

        int result = 0;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/closer?useSSL=false", "root", "154263LoL");
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getUserEmail());
                preparedStatement.setString(3, user.getUserPassword());
                preparedStatement.setString(4, user.getUserProfilePic());

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();

        }catch(SQLException e) {
        // process sql exception
            printSQLException(e);
        }

        return result;
    }

    public boolean validateUser(User user) {
        String VALIDATE_USER_SQL = "select * from login where username = ? and password = ?";
        boolean status = false;

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/closer?useSSL=false", "root", "154263LoL");
             PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_USER_SQL)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPassword());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();

        }catch(SQLException e) {
            // process sql exception
            printSQLException(e);
        }

        return status;
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
