package ServerApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

    private ServerSocket serverSocket;
    private LoginService authorisationService;
    private StoryManagement history;
    private ExecutorService threadsController;

    public void boot() {
        authorisationService = new LoginService();
        history = new StoryManagement(this);
        threadsController = Executors.newCachedThreadPool();

        try {
            this.serverSocket = new ServerSocket(555);
            System.out.println("Server is up and waiting for connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection commited.");
                new UserConnection(socket, this);
                System.out.println("Connection confirmed.");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public LoginService getAuthorisationService() {
        return authorisationService;
    }

    public void sendBroadcast(String message) {
        for (UserConnection a : authorisationService.getConnectionList()) {
            a.sendMessage(message);
            history.addToHistory(a.getLogin(), message);
        }
    }

    public void whisper(String message, String recipient, UserConnection author) {
        UserConnection address = authorisationService.getRecipient(recipient);
        if (address != null) {
            author.sendMessage(message);
            history.addToHistory(author.getLogin(), message);
            address.sendMessage(message);
            history.addToHistory(address.getLogin(), message);
        } else {
            author.sendMessage("Server >>> Сообщение не доставлено. Пользователь " + recipient + " в настоящий помент не в сети.");
        }
    }

    public StoryManagement getHistoryStorage() {
        return this.history;
    }

    public ExecutorService getThreadsController (){
        return this.threadsController;
    }

}
