package UserApp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Consumer;

public class ClientApp {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public ClientApp(){
        try {
            this.socket = new Socket("127.0.0.1",555);
            this.in=new DataInputStream(socket.getInputStream());
            this.out=new DataOutputStream(socket.getOutputStream());
            System.out.println("соединение установлено");
        } catch (IOException e) {
            System.out.println("Server is down...");
            System.exit(0);
        }

        Visualisator frame = new Visualisator(new Consumer<String>() {
            @Override
            public void accept(String message) {
                try {
                    out.writeUTF(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        new Thread(()->{
            while (true){
                try {
                    String message = this.in.readUTF();
                    frame.printMessage(message);

                } catch (Exception e) {
                    System.out.println("Server disconnected...");
                    exit();
                    break;
                }
            }
        }).start();

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
