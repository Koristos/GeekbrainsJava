public class Truck extends AutoVessel{
    public static int truckCount=0;
    Truck (FuelStation toRecharge){
        super(toRecharge, 60, 15);
        truckCount++;
        super.setName("TRUCK #"+truckCount);
    }
}
