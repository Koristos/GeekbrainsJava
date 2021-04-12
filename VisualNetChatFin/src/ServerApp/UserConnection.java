package ServerApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class UserConnection {
    private User user=null;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private ChatServer server;
    private ExecutorService controller;

    UserConnection(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
        this.controller=server.getThreadsController();
        try {
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            exit();
        }

        controller.execute(()->{
            try {
                Thread.sleep(120000);
                if(this.user==null) exit();
            } catch (InterruptedException e) {
                System.out.println("Verification expired");
            }
        });


        controller.execute(()->{
            try {
                server.getAuthorisationService().authorise(this);
                server.getHistoryStorage().checkUserHistoryFile(this.getLogin());
                server.getHistoryStorage().getHistory(this);
            } catch (IOException e) {
                System.out.println("Verification expired");
            }
            while (true){
                try {
                    transferMessage(getMessage());
                } catch (IOException e) {
                    if (this.user!=null)System.out.println(this.user.getNickname()+" Disconnected");
                    exit();
                    break;
                }
            }
        });

    }

    public String getLogin() {
        return this.user.getLogin();
    }

    public String getNickname(){
        return this.user.getNickname();
    }


    public void setUser(User user){

        this.user=user;
    }

    public void sendMessage (String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            System.out.println(this.user.getNickname()+" Disconnected");
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
            messageToSend=this.user.getNickname() + " шепчет "+recipient+" >>> "+ message;
            server.whisper(messageToSend, recipient, this);
        }else if (message.startsWith("cmd close")) {
            exit();
        }else if (message.startsWith("cmd changeNickName ")){
            String[] textArray = message.split("\\s");
            String nick = textArray[2];
            User tempUser = new User(this.user.getLogin(),this.user.getPassword(),nick);
            this.server.getAuthorisationService().changeNickName(this,tempUser);
        }else {
            messageToSend= this.user.getNickname() + " >>> "+message;
            server.sendBroadcast(messageToSend);
        }

    }

    protected void exit (){
        try {
            server.getAuthorisationService().removeChatConnection(this);
            server.sendBroadcast("Server >>>Пользователь "+this.user.getNickname() + " покинул чат.");
            this.in.close();
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
