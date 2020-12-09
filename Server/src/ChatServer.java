import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    private ServerSocket serverSoc;
    private DataInputStream inStream;
    private DataOutputStream outStream;
    private String name = "Server";

    ChatServer() {
        try {
            bootServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bootServer() throws IOException {
        serverSoc = new ServerSocket(5555);
        System.out.println("Server is ready for client connection.");
        Socket clientSoc = serverSoc.accept();

        System.out.println("Client " + clientSoc + " connected.");

        inStream = new DataInputStream(clientSoc.getInputStream());
        outStream = new DataOutputStream(clientSoc.getOutputStream());

        new Thread(() -> {
            try {
                while (true) {
                    String inputMessage = inStream.readUTF();
                    System.out.println(inputMessage);
                    if (inputMessage.contains("cmd exit"))exit("Client had left.");
                }
            } catch (IOException e) {
                exit("Client disconnected");
            }
        }).start();

        while (true) {
            Scanner scan = new Scanner(System.in);
            String outputMessage = scan.nextLine();
            if (outputMessage.contains("cmd exit")){
                outputMessage="Server shut down";
                outStream.writeUTF(outputMessage);
                exit(outputMessage);
            }
            outStream.writeUTF(name + ": " + outputMessage);
        }

    }

    private void exit(String message) {
        try {
            inStream.close();
            outStream.close();
            System.out.println(message);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

