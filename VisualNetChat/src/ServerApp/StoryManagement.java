package ServerApp;

import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.*;
import java.util.ArrayList;


public class StoryManagement {
    private File path;
    private ChatServer server;

    public StoryManagement(ChatServer server){
        this.path = new File("History");
        path.mkdir();
        this.server=server;
    }

    public void checkUserHistoryFile (String login){
        File history = new File(this.path+"\\"+login+".txt");
        if (!history.exists()){
            try {
                history.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addToHistory (String login, String message){
        File history = new File(this.path+"\\"+login+".txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(history, true));
            writer.newLine();
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getHistory (UserConnection connection){
        File history = new File(this.path+"\\"+connection.getLogin()+".txt");
        ArrayList<String> historyArray = new ArrayList<String>();
        String tempString;
        try {
            ReversedLinesFileReader reader = new ReversedLinesFileReader(history);
            for (int i = 0; i < 5; i++) {
                if ((tempString=reader.readLine())!=null){
                    historyArray.add(tempString);
                }else break;
            }

    } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < historyArray.size(); i++) {
            connection.sendMessage(historyArray.get(historyArray.size() - i-1));
        }

    }
}