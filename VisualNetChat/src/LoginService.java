import java.io.IOException;
import java.util.HashSet;

public class LoginService {
    private HashSet <UserConnection> connectionList=new HashSet<>();
    private ClientList clientList = new ClientList();

    public void authorise(UserConnection connection) throws IOException {
        boolean authorisationPassed=false;
        do {
            connection.sendMessage("cmd authorisation Пожалуйста, введите логин.");
            String login = connection.getMessage();
            connection.sendMessage("cmd authorisation Пожалуйста, введите пароль.");
            String password = connection.getMessage();
            if(clientList.login(login,password)) authorisationPassed=true;
            else connection.sendMessage("authorisationmessage Вы ввели неверные данные, попробуйте еще раз.");
            if (authorisationPassed){
                if (isConnected(login)){
                    connection.sendMessage("authorisationmessage Данный пользователь уже авторизован. Попробуйте другую учетную запись.");
                    authorisationPassed=false;
                }else {
                    connection.setLogin(login);
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

    public UserConnection getRecipient (String login){
        for (UserConnection i: connectionList) {
            if (i.getLogin().equals(login))return i;
        }
        return null;
    }
}
