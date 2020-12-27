import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.function.Consumer;

public class MenuPannel {

    private JPanel menu;
    private CenterPannel operationPannel;
    private HashSet <ColorMenuItem> colorSet;
    private Consumer<String> sendMessage;


    MenuPannel (CenterPannel pannelToOperate, Consumer sendMessage) {
        this.operationPannel=pannelToOperate;
        this.sendMessage=sendMessage;
        menu = new JPanel();
        menu.setBorder(new EmptyBorder(2, 10,0,10));
        JMenuBar chatMenu = new JMenuBar();

        JMenu settings= new JMenu("Настройки");
        JMenuItem profile = new JMenuItem("Имя пользователя");
        profile.addActionListener(setProfile());
        JMenu fontColor = new JMenu("Цвет шрифта");
        JMenuItem exitChat = new JMenuItem("Покинуть чат");
        exitChat.addActionListener(close());

        colorSet = new HashSet<>();
        colorSet.add(new ColorMenuItem("Красный", Color.RED, false));
        colorSet.add(new ColorMenuItem("Зеленый", Color.GREEN, false));
        colorSet.add(new ColorMenuItem("Черный", Color.BLACK, true));
        for (ColorMenuItem i:colorSet) {
            i.addActionListener(setFont());
            fontColor.add(i);
        }

        settings.add(profile);
        settings.add(fontColor);
        settings.add(exitChat);
        chatMenu.add(settings);

        menu.setLayout(new GridLayout());
        menu.add(chatMenu);

    }

    public JPanel getPannel(){
        return this.menu;
    }

    private ActionListener close(){
        ActionListener exitChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        return exitChat;
    }

    private ActionListener setProfile(){
        ActionListener setName=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage.accept("cmd changeNickName "+JOptionPane.showInputDialog("Введите ваше имя:"));
            }
        };
        return setName;
    }

    private ActionListener setFont(){
        ActionListener fontColor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ColorMenuItem i :colorSet) {
                    i.setState(false);
                    if (e.getSource().equals(i)){
                        i.setState(true);
                        operationPannel.setColor(i.getColor());
                    }
                }


            }
        };
        return fontColor;
    }



}
