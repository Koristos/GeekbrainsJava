
import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {
    CenterPannel center;
    SouthPannel south;
    MenuPannel menu;

    public ChatFrame(){
        setTitle("Сетевой Чат");
        setBounds(350,250,1000,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        center =new CenterPannel();
        south = new SouthPannel(center);
        menu = new MenuPannel(center);
        add(center.getPannel(),BorderLayout.CENTER);
        add(south.getPannel(),BorderLayout.SOUTH);
        add(menu.getPannel(), BorderLayout.NORTH);
        setVisible(true);

    }


}
