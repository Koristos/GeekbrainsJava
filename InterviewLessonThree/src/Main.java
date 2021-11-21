public class Main {
    public static void main(String[] args) throws InterruptedException {
        WordWriter wordWriter = new WordWriter();
        Thread a = new Thread(()->{
            synchronized (wordWriter){
                while (!Thread.interrupted()) {
                    wordWriter.print("Ping\n");
                    wordWriter.notifyAll();
                    try {
                        wordWriter.wait();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Thread b = new Thread(()->{
            synchronized (wordWriter){
                while (!Thread.interrupted()) {
                    wordWriter.print("Pong\n");
                    wordWriter.notifyAll();
                    try {
                        wordWriter.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        a.start();
        b.start();
        Thread.sleep(10000);
        a.interrupt();
        b.interrupt();

        SafeCountHolder safeCountHolder = new SafeCountHolder();

        Thread c = new Thread(()->{
                while (!Thread.interrupted()) {
                  safeCountHolder.doCount();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
        });

        Thread d = new Thread(()->{
            while (!Thread.interrupted()) {
                safeCountHolder.doCount();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        c.start();
        d.start();
        Thread.sleep(10000);
        c.interrupt();
        d.interrupt();
    }
}
