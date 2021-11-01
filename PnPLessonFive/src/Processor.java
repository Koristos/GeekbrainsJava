import java.util.Random;

public class Processor {

    public void process (String string){
        System.out.println(string);
    }

    public boolean isReady(){
        Random rnd = new Random();
        return rnd.nextInt(10)<2;
    }
}
