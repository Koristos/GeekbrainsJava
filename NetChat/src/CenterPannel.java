import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;

public class CenterPannel {
    private String nickName = "Аноним";
    private JPanel centerPan;
    private JTextPane chatLog;
    private Color color=Color.black;



    CenterPannel () {
        centerPan = new JPanel();
        ScrollPane chatScroll=new ScrollPane();
        chatLog = new JTextPane();
        chatLog.setEditable(false);
        chatLog.setFont(new Font("chatFont",Font.PLAIN,18));
        chatLog.setBackground(Color.lightGray);
        centerPan.setLayout(new GridLayout());
        chatScroll.add(chatLog);
        centerPan.add(chatScroll);
        centerPan.setBorder(new EmptyBorder(2,10,10,10));
    }

    protected JPanel getPannel(){
        return this.centerPan;
    }

    protected void addMessage(String message){
        String compiledMessage = "\n"+this.nickName+" >>> "+message;
        StyleContext style = StyleContext.getDefaultStyleContext();
        AttributeSet aset = style.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, this.color);
        int charPose = chatLog.getDocument().getLength();
        this.chatLog.setEditable(true);
        this.chatLog.setCaretPosition(charPose);
        this.chatLog.setCharacterAttributes(aset, false);
        this.chatLog.replaceSelection(compiledMessage);
        this.chatLog.setEditable(false);

    }

    protected void setNickName (String name){
        this.nickName = name;
    }

    protected void setColor (Color toSet){
        this.color=toSet;
    }

}
