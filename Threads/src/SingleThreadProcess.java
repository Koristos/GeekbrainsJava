import java.util.Arrays;
import java.util.Date;

public class SingleThreadProcess implements Runnable{

    float[] origin;

    SingleThreadProcess(int size){
        origin = new float[size];
        Arrays.fill(origin,1f);
    }

    public void go(){

        long startTime = System.currentTimeMillis();
        System.out.println(String.format("Вычисления 1 начаты в %s", new Date()));

        count(origin);

        System.out.println(String.format("Вычисления 1 закончены за %s миллисекунд.",(System.currentTimeMillis()-startTime)));

    }

    public void count(float[] toCount){

        for (int i=0;i<toCount.length;i++) {
            float index=(float)i;
            toCount [i] = (float) (toCount[i]*Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
        }
    }

    @Override
    public void run() {
        this.go();
    }
}
