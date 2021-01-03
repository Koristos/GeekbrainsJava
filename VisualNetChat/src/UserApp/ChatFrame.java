package UserApp;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ChatFrame extends JFrame {
    CenterPannel center;
    SouthPannel south;
    MenuPannel menu;
    private Consumer <String> sendMessage;

    public ChatFrame(Consumer sendMessage){
        this.sendMessage=sendMessage;
        setTitle("Сетевой Чат");
        setBounds(350,250,1000,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        center =new CenterPannel();
        south = new SouthPannel(center,this.sendMessage);
        menu = new MenuPannel(center, this.sendMessage);
        add(center.getPannel(),BorderLayout.CENTER);
        add(south.getPannel(),BorderLayout.SOUTH);
        add(menu.getPannel(), BorderLayout.NORTH);
        setVisible(true);

    }

    public void authorisationRequest(String authText){
        sendMessage.accept(JOptionPane.showInputDialog (authText));
    }

    public void authorisationMessage(String authText){
        JOptionPane.showMessageDialog(null,authText);
    }


}
