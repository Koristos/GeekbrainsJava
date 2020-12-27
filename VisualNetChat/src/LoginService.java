import java.io.IOException;
import java.util.HashSet;

public class LoginService {
    private HashSet <UserConnection> connectionList=new HashSet<>();
    private ClientBase clientList = new ClientBase();

    public void authorise(UserConnection connection) throws IOException {
        boolean authorisationPassed=false;
        do {
            connection.sendMessage("cmd authorisation Пожалуйста, введите логин.");
            String login = connection.getMessage();
            connection.sendMessage("cmd authorisation Пожалуйста, введите пароль.");
            String password = connection.getMessage();
            User user = clientList.checkUser(login);
            if(user!=null && user.getPassword().equals(password)) authorisationPassed=true;
            else connection.sendMessage("authorisationmessage Вы ввели неверные данные, попробуйте еще раз.");
            if (authorisationPassed){
                if (isConnected(user.getLogin())){
                    connection.sendMessage("authorisationmessage Данный пользователь уже авторизован. Попробуйте другую учетную запись.");
                    authorisationPassed=false;
                }else {
                    connection.setUser(user);
                    addChatConnection(connection);
                    connection.sendMessage("authorisationmessage Вы авторизованы. Добро пожаловать в чат!");
                }
            }
        }while (!authorisationPassed);

    }

    public boolean isConnected (String login){
        try {
            for (UserConnection i : connectionList) {
                if (i.getLogin().equals(login)) return true;
            }
        }catch (NullPointerException e){
            return false;
        }
        return false;
    }

    private void addChatConnection (UserConnection connection){
        connectionList.add(connection);
    }

    public void removeChatConnection(UserConnection connection) {
        connectionList.remove(connection);
    }

    public HashSet <UserConnection> getConnectionList(){
        return connectionList;
    }

    public UserConnection getRecipient (String nickName){
        for (UserConnection i: connectionList) {
            if (i.getNickname().equals(nickName))return i;
        }
        return null;
    }

    public void changeNickName (UserConnection connection,User updatedUser){
        if (clientList.changeNickname(updatedUser)==1){
            connection.setUser(updatedUser);
            connection.sendMessage("authorisationmessage Ваш псевдоним успешно изменен!");
        }else if (clientList.changeNickname(updatedUser)==99){
            connection.sendMessage("authorisationmessage Данный псевдоним уже занят!");
        }else connection.sendMessage("authorisationmessage Ошибка обновления. Попробуйте еще раз!");
    }
}
