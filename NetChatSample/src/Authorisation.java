import java.io.IOException;
import java.util.HashSet;

public class Authorisation {

    private HashSet <ChatConnection> connectionList=new HashSet<>();
    private ClientList clientList = new ClientList();

    public void authorise(ChatConnection connection) throws IOException {
        boolean authorisationPassed=false;
        do {
            connection.sendMessage("Server >>> Пожалуйста, введите ваш логин.");
            String login = connection.getMessage();
            connection.sendMessage("Server >>> Пожалуйста, введите пароль.");
            String password = connection.getMessage();
            if(clientList.login(login,password)) authorisationPassed=true;
            else connection.sendMessage("Server >>> Вы ввели неверные данные, попробуйте еще раз.");
            if (authorisationPassed){
                if (isConnected(login)){
                    connection.sendMessage("Server >>> Данный пользователь уже авторизован. Попробуйте другую учетную запись.");
                    authorisationPassed=false;
                }else {
                    connection.setLogin(login);
                    addChatConnection(connection);
                    connection.sendMessage("Server >>> Вы авторизованы. Добро пожаловать в чат!");
                }
            }
        }while (!authorisationPassed);

    }

    public boolean isConnected (String login){
        try {
            for (ChatConnection i : connectionList) {
                if (i.getLogin().equals(login)) return true;
            }
        }catch (NullPointerException e){
            return false;
        }
        return false;
    }

    private void addChatConnection (ChatConnection connection){
        connectionList.add(connection);
    }

    public void removeChatConnection(ChatConnection connection) {
        connectionList.remove(connection);
    }

    public HashSet <ChatConnection> getConnectionList(){
        return connectionList;
    }

    public ChatConnection getRecipient (String login){
        for (ChatConnection i: connectionList) {
            if (i.getLogin().equals(login))return i;
        }
        return null;
    }
}
