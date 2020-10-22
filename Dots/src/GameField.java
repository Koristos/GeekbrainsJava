import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;

public class GameField extends JFrame {

    DotButton[][] buttonArray;
    JLabel textField;

    GameField(int fieldSize){
        super("КРЕСТИКИ-НОЛИКИ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize((20+fieldSize*105),(110+fieldSize*105));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JPanel centerField=new JPanel();
        centerField.setBackground(Color.BLACK);
        GridLayout gridField=new GridLayout(fieldSize,fieldSize,5,5);
        centerField.setLayout(gridField);
        buttonArray=new DotButton[fieldSize][fieldSize];
        for (int i=0; i <fieldSize; i++){
            for (int y=0; y<fieldSize;y++){
                centerField.add(buttonArray[i][y]=new DotButton(i,y));
            }
        }
        getContentPane().add(centerField);
        textField=new JLabel("");
        Font font =new Font("Comic Sans MS", Font.ITALIC,15);
        textField.setFont(font);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
        getContentPane().add(textField,BorderLayout.NORTH);
        setVisible(true);

    }

    public void Imcha(int row, int num, int turn){
        if (turn==-1)buttonArray[row][num].SetCross();
        else buttonArray[row][num].SetNoll();
    }

    public void CompSay(int action){
        String[]textArray=new String[]{"Ходи уже!", "Я непобедим!","Ну сколько можно думать?", "Может тебе подсказать?", "Эй! Мы не в поддавки играем!"};
        Random rnd=new Random();
        if(action==1) textField.setText(textArray[rnd.nextInt(textArray.length)]);
        if(action==2) textField.setText("Эта ячейка занята. Попробуй еще раз!");
    }




}
