package UserApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

public class SouthPannel {

    private JPanel southPannel;
    private TextField enterTextField;
    private JButton sendButton;
    private CenterPannel operationPannel;
    private Consumer <String> sendText;

    SouthPannel (CenterPannel centerToOperate, Consumer sendText) {
        this.sendText=sendText;
        this.operationPannel=centerToOperate;
        southPannel = new JPanel();
        southPannel.setBorder(new EmptyBorder(0,10,10,10));
        southPannel.setLayout(new BorderLayout());
        enterTextField = new TextField();
        enterTextField.setFont(new Font("chatFont",Font.PLAIN,16));
        enterTextField.addKeyListener(pressEnter());
        sendButton=new JButton("Send");
        sendButton.addActionListener(pressButton());
        southPannel.add(enterTextField,BorderLayout.CENTER);
        southPannel.add(sendButton, BorderLayout.EAST);
    }

    protected JPanel getPannel(){
        return this.southPannel;
    }

    private void sendMessage(){

        sendText.accept(enterTextField.getText());
        enterTextField.setText("");
    }

    private ActionListener pressButton(){
        ActionListener buttonPressed = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        };
        return buttonPressed;
    }

    private KeyListener pressEnter(){
        KeyListener enterPressed = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==10) sendMessage();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        return enterPressed;
    }


}
