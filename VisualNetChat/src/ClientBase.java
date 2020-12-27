import java.sql.*;

public class ClientBase {

    public int createUser (User newUser){
        Connection connection = ConnectionService.connectUserBase();
        int row=0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO userbase (login, password, nickname) VALUES (?, ?, ?)");
            statement.setString(1, newUser.getLogin());
            statement.setString(2,newUser.getPassword());
            statement.setString(3,newUser.getNickname());

            row = statement.executeUpdate();

            connection.commit();

            return row;

        } catch (SQLIntegrityConstraintViolationException e){
            row=99;
        }catch (SQLException throwables) {
            ConnectionService.rollback(connection);
            throwables.printStackTrace();
        }finally {
            ConnectionService.close(connection);
        }
        return row;
    }

    public User checkUser (String login){
        Connection connection = ConnectionService.connectUserBase();
        User user = null;
        try {
        PreparedStatement statement = connection.prepareStatement("SELECT * from userbase WHERE login = ?");
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString("login"), rs.getString("password"), rs.getString("nickname"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public int changeNickname (User user){
        Connection connection = ConnectionService.connectUserBase();
        int row=0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE userbase SET nickname = ? WHERE login = ?");
            statement.setString(1, user.getNickname());
            statement.setString(2,user.getLogin());

            row = statement.executeUpdate();

            connection.commit();

            return row;

        } catch (SQLIntegrityConstraintViolationException e){
            row=99;
        }catch (SQLException throwables) {
            ConnectionService.rollback(connection);
            throwables.printStackTrace();
        }finally {
            ConnectionService.close(connection);
        }
        return row;
    }

}
