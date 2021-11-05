import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private final String DB_URL = "jdbc:mysql://localhost:3306/repouserbase";
    private final String DB_USER = "user";
    private final String DB_PASSWORD = "password";

    protected Connection connectUserBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException throwables) {
            return null;
        }
    }

    protected void rollBack(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException throwables) {
        }
    }

    protected void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
        }
    }
}