import javax.swing.*;
import java.awt.*;

public class GameOver extends JOptionPane {
    private ImageIcon game =new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("res/game.png")));
    GameOver(String message){
        int result=showConfirmDialog(this, message,"Game Over",YES_NO_OPTION, INFORMATION_MESSAGE,game);
        if (result==1) System.exit(0);
    }
}
