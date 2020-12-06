
public class Threads {

    public static void main(String[] args) throws InterruptedException {

        int size = 1000000;
        long startTime = System.currentTimeMillis();

        new SingleThreadProcess(size).go();
        new TwoThreadsProsess(size).go();

        System.out.println("\nПри одновременном выполнении:");
        Thread one = new Thread(new SingleThreadProcess(size));
        Thread two = new Thread(new TwoThreadsProsess(size));

        one.start();
        two.start();


    }
}

