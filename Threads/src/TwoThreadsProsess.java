import java.util.Date;

public class TwoThreadsProsess extends SingleThreadProcess {

    TwoThreadsProsess(int size){
        super(size);
    }


    public void go() {
        int h = super.origin.length/2;

        long startTime = System.currentTimeMillis();
        System.out.println(String.format("Вычисления 2 начаты в %s", new Date()));

        float [] firstPart = new float[h];
        float [] secondPart = new float[h];
        System.arraycopy(super.origin,0,firstPart,0,h);
        System.arraycopy(super.origin,h,secondPart,0,h);

        new Thread(()->{
            synchronized (firstPart) {
                super.count(firstPart);
            }
        }).start();
        new Thread(()->{
            synchronized (secondPart) {
                super.count(secondPart);
            }
        }).start();


        synchronized (firstPart) {
            synchronized (secondPart) {

                System.arraycopy(firstPart, 0, super.origin, 0, h);
                System.arraycopy(secondPart, 0, super.origin, h, h);
                System.out.println(String.format("Вычисления 2 закончены за %s миллисекунд.", (System.currentTimeMillis() - startTime)));
            }
        }

    }

}
