import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private ServerSocket serverSocket;
    private LoginService authorisationService;

    public void boot (){
        authorisationService=new LoginService();

        try {
            this.serverSocket=new ServerSocket(555);
            System.out.println("Server is up and waiting for connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection commited.");
                new UserConnection(socket,this);
                System.out.println("Connection confirmed.");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public LoginService getAuthorisationService(){
        return authorisationService;
    }

    public void sendBroadcast(String message){
        for (UserConnection a:authorisationService.getConnectionList()) {
            a.sendMessage(message);
        }
    }

    public void whisper (String message,String recipient, UserConnection author){
        UserConnection address = authorisationService.getRecipient(recipient);
        if(address!=null){
            author.sendMessage(message);
            address.sendMessage(message);
        }else {
            author.sendMessage("Server >>> Сообщение не доставлено. Пользователь "+recipient+" в настоящий помент не в сети.");
        }
    }

}
