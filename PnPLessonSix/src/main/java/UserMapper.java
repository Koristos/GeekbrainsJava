import java.sql.*;

public class UserMapper {
    private final ConnectionService connector;

    UserMapper() {
        connector = new ConnectionService();
    }

    public void putUser (User user) {
        Connection connection = connector.connectUserBase();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (id, name, birthDate, phone) VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setDate(3, new Date(user.getBirthDate().getTime()));
            statement.setString(4, user.getPhone());
            connection.commit();
        } catch (SQLException throwables) {
            connector.rollBack(connection);
        } finally {
            connector.close(connection);
        }
    }

    public User getUser (Integer userId) {
        Connection connection = connector.connectUserBase();
        User user= new User();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users  WHERE (id = ?)"
            );
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setBirthDate(resultSet.getDate(3));
            user.setPhone(resultSet.getString(4));
        } catch (SQLException throwables) {
            connector.rollBack(connection);
            return null;
        } finally {
            connector.close(connection);
        }
        return user;
    }

}
