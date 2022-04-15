import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeCountHolder {
    private int count = 0;
    Lock lock = new ReentrantLock(true);
    public void doCount(){
        try {
            if (lock.tryLock(10, TimeUnit.SECONDS)) {
                count++;
                System.out.println(count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
