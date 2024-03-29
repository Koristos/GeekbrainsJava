package ServerApp;

import java.sql.*;

public class ClientBase {

    public String createUser (User newUser){
        Connection connection = ConnectionService.connectUserBase();
        String result=null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO userbase (login, password, nickname) VALUES (?, ?, ?)");
            statement.setString(1, newUser.getLogin());
            statement.setString(2,newUser.getPassword());
            statement.setString(3,newUser.getNickname());

            if (statement.executeUpdate()==1){
                result="done";
            }
            connection.commit();
            return result;

        } catch (SQLIntegrityConstraintViolationException e){
            result="parameters occupied";
        }catch (SQLException throwables) {
            ConnectionService.rollback(connection);
            throw new RuntimeException("SWW with creating new user. Rollback committed.");
        }finally {
            ConnectionService.close(connection);
        }
        return result;
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
            throw new RuntimeException("SWW with checking user in database.");
        }finally {
            ConnectionService.close(connection);
        }
        return user;
    }

    public String changeNickname (User user){
        Connection connection = ConnectionService.connectUserBase();
        String result=null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE userbase SET nickname = ? WHERE login = ?");
            statement.setString(1, user.getNickname());
            statement.setString(2,user.getLogin());

            if (statement.executeUpdate()==1){
                result="done";
            }
            connection.commit();
            return result;

        } catch (SQLIntegrityConstraintViolationException e){
            result="parameters occupied";
        }catch (SQLException throwables) {
            ConnectionService.rollback(connection);
            throw new RuntimeException("SWW with updating user. Rollback committed.");
        }finally {
            ConnectionService.close(connection);
        }
        return result;
    }

}
