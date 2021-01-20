import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FuelStation gasStation = new FuelStation();
        ArrayList<AutoVessel> autoPark = new ArrayList<AutoVessel>();
        addVessels(autoPark, 10,6,4,gasStation);

        ExecutorService threadPool = Executors.newFixedThreadPool(autoPark.size());

        for (AutoVessel a: autoPark) {
            threadPool.submit(a);
        }


    }

    public static void addVessels(ArrayList<AutoVessel> addTo, int carsCount, int trucksCount, int busCount, FuelStation gasStation){
        for (int i = 0; i < carsCount; i++) {
            addTo.add(new Car(gasStation));
        }
        for (int i = 0; i < trucksCount; i++) {
            addTo.add(new Truck(gasStation));
        }
        for (int i = 0; i < busCount; i++) {
            addTo.add(new Bus(gasStation));
        }
    }
}
