import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    ChatClient(){
        try {
            this.socket = new Socket("127.0.0.1",555);
            this.in=new DataInputStream(socket.getInputStream());
            this.out=new DataOutputStream(socket.getOutputStream());
            System.out.println("соединение установлено");
        } catch (IOException e) {
            System.out.println("Server is down...");
            System.exit(0);
        }

        new Thread(()->{
            while (true){
                try {
                   String message = this.in.readUTF();
                   System.out.println(message);

                } catch (Exception e) {
                    System.out.println("Server disconnected...");
                    exit();
                    break;
                }
            }
        }).start();

        Scanner scan = new Scanner(System.in);
        while (true){
            String message = scan.nextLine();
            sendMessage(message);
            if (message.startsWith("cmd exit")) exit();
        }

    }

    private void sendMessage(String message){
        try {
            this.out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void exit(){
        try {
            this.in.close();
            this.out.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
