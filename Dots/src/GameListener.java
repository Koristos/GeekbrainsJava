import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DotButton butPress=(DotButton)e.getSource();
        int[] butNum= butPress.GetButtonNumber();
        DotGame.SetMove(butNum);
        DotGame.goOn=true;

    }
}
