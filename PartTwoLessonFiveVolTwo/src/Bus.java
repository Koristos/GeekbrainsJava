public class Bus extends AutoVessel{
    public static int busCount=0;
    Bus (FuelStation toRecharge){
        super(toRecharge, 40, 7.5);
        busCount++;
        super.setName("BUS #"+busCount);
    }
}
