import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Cat {
    private boolean hunger;
    private int appetite;
    private String name;

    Cat(String name){
        Random rnd= new Random();
        this.name=name;
        this.appetite=rnd.nextInt(10)+10;
        this.hunger=true;

    }

    public boolean IsHungry(){
        String toPrint=hunger==true?this.name+" смотрит на тебя голодными глазами.":this.name+" Дрыхнет. Он явно не голоден.";
        System.out.println(toPrint);
        return hunger;
    }

    public String GetName(){
        return this.name;
    }

    public void Feed(Plate plateToEat){
        if (hunger==false) System.out.println(this.name+" не хочет есть.");
        else if (plateToEat.Feed(this.appetite)==true){
            this.hunger=false;
            System.out.println(this.name+" поел и теперь мурчит под лавкой.");
            HungerTimer();
        }else if(plateToEat.Feed(this.appetite)==false) System.out.println(this.name+" смотрит на вас с презрением. Здесь явно недостаточно еды для кота в полном расцвете сил.");
    }

    private void HungerTimer(){
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                hunger=true;
                System.out.println(name+" проголодался и истошно орет. Покорми его быстрее.");
            }
        };
        Timer timer=new Timer();
        timer.schedule(task,20000L);
    }


}
