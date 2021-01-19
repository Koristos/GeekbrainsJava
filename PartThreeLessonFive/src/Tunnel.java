import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore controller;
    public Tunnel(int maxCapacity) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.controller = new Semaphore(maxCapacity);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                if (controller.availablePermits()==0) System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                controller.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                controller.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}