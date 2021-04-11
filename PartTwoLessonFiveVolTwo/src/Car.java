public class Car extends AutoVessel {
    public static int carCount=0;
    Car (FuelStation toRecharge){
        super(toRecharge, 20, 2.5);
        carCount++;
        super.setName("CAR #"+carCount);
    }
}
