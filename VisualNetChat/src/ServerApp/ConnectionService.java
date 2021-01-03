package ServerApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionService {

    private ConnectionService(){}
    public static Connection connectUserBase (){
        Connection connection=null;
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/authbase", "root", "12345");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
