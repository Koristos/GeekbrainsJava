import javax.swing.*;
import java.awt.*;

public class DotButton extends JButton {
    private ImageIcon cross =new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("res/cross.png")));
    private ImageIcon noll =new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("res/noll.png")));
    private ImageIcon empty =new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("res/empty.png")));


    private int[] buttonNumber;
    DotButton(int row, int num){
        this.setIcon(empty);
        setSize(100,100);
        this.setBackground(Color.WHITE);
        buttonNumber=new int[]{row,num};
        this.addActionListener(new GameListener());

    }

    public int [] GetButtonNumber(){
        return buttonNumber;
    }

    public void SetCross(){
        this.setIcon(cross);
    }

    public void SetNoll(){
        this.setIcon(noll);
    }

}
