import javax.swing.*;
import java.awt.*;

public class NewGame extends JOptionPane {
    private ImageIcon cross =new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("res/cross.png")));
    private ImageIcon noll =new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("res/noll.png")));
    private ImageIcon game =new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("res/game.png")));
    private ImageIcon[] options=new ImageIcon[]{cross,noll};
    NewGame(){
        int result=showOptionDialog(this, "Сыграем в крестики-нолики? \nВыбери свойзнак!",
                "НОВАЯ ИГРА",YES_NO_OPTION,INFORMATION_MESSAGE,game,options,1);
        DotGame.SetTurn(result);
    }
}
