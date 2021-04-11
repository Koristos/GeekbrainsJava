import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserConnection {
    private String login="Unknown User";
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private ChatServer server;

    UserConnection(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            exit();
        }

        new Thread(()->{
            try {
                Thread.sleep(120000);
                if(this.login.equals("Unknown User")) exit();
            } catch (InterruptedException e) {
                System.out.println("Verification expired");
            }
        }).start();


        new Thread(()->{
            try {
                server.getAuthorisationService().authorise(this);
            } catch (IOException e) {
                System.out.println("Verification expired");
            }
            while (true){
                try {
                    transferMessage(getMessage());
                } catch (IOException e) {
                    System.out.println(this.login+" Disconnected");
                    exit();
                    break;
                }
            }
        }).start();

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login){
        this.login=login;
    }

    public void sendMessage (String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            System.out.println(this.login+" Disconnected");
        }
    }

    public String getMessage () throws IOException {
        String message="";
        message = this.in.readUTF();
        return message;
    }

    private void transferMessage(String message){
        String messageToSend;
        if (message.startsWith("/w")) {
            String[] textArray = message.split("\\s");
            String recipient = textArray[1];
            message = message.substring((4 + textArray[1].length()));
            messageToSend=this.login + " шепчет "+recipient+" >>> "+ message;
            server.whisper(messageToSend, recipient, this);
        }else if (message.startsWith("cmd close")){
            exit();
        }else {
            messageToSend= this.login + " >>> "+message;
            server.sendBroadcast(messageToSend);
        }

    }

    protected void exit (){
        try {
            server.getAuthorisationService().removeChatConnection(this);
            server.sendBroadcast("Server >>>Пользователь "+this.login + " покинул чат.");
            this.in.close();
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
