import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket clientSoc;
    private DataInputStream inStream;
    private DataOutputStream outStream;
    private String name = "Client";

    Client(){

            bootClient();

    }

    private void  bootClient() {
        try {
            clientSoc = new Socket("127.0.0.1", 5555);
            System.out.println("Connected to server");

            inStream = new DataInputStream(clientSoc.getInputStream());
            outStream = new DataOutputStream(clientSoc.getOutputStream());

            new Thread(() -> {
                while (true) {
                    try {
                        String inputMessage = inStream.readUTF();
                        System.out.println(inputMessage);
                    } catch (IOException e) {
                        exit("Connection is closed.");
                    }
                }
            }).start();

            while (true) {
                Scanner scan = new Scanner(System.in);
                String outputMessage = scan.nextLine();
                outStream.writeUTF(name + ": " + outputMessage);
                if (outputMessage.contains("cmd exit"))exit("You left the chat.");
            }
        }catch (Exception e){
            System.out.println("Server not found.");
        }

    }

    private void exit (String message) {
        try {
            inStream.close();
            outStream.close();
            System.out.println(message);
            System.exit(0);
        }catch (IOException e){
        e.printStackTrace();
    }

    }
}
