import java.util.concurrent.Semaphore;

public class FuelStation {
    private final int gasDispensers = 3;
    private Semaphore controller;

    FuelStation(){
       this.controller=new Semaphore(this.gasDispensers,true);
    }


    public boolean buyGas(double volume, String name){
        if (controller.availablePermits()==0){
            System.out.println(name+" становится в очередь на заправку.");
        }
        try {
            controller.acquire();
            System.out.println(name+" заливает топливо.");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("SWW during "+name+" recharge.");
        }finally {
            controller.release();
            System.out.println(name+" заправился и освободил колонку.");
        }

        return true;
    }

}
