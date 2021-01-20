public abstract class AutoVessel implements Rechargeable, Runnable{

    private FuelStation toRecharge;
    private double fuelTankVolume;
    private double fuelConsumption;
    private double gasLeft;
    private String name;

    AutoVessel (FuelStation toRecharge, double fuelTankVolume, double fuelConsumption){
        this.toRecharge=toRecharge;
        this.fuelConsumption=fuelConsumption;
        this.fuelTankVolume=fuelTankVolume;
        this.gasLeft=fuelTankVolume;
    }

    @Override
    public void recharge() {
        double gasVolumeMissing = this.fuelTankVolume-gasLeft;
        if (toRecharge.buyGas(gasVolumeMissing, this.name)){
            this.gasLeft+=gasVolumeMissing;
            System.out.println(this.name + " готов ехать дальше");
        }

    }

    @Override
    public void run() {
        do {
            System.out.println(this.name + " выехал на дорогу.");
            while ((gasLeft - fuelConsumption) > 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException("SWW with " + this.name + " on the road");
                }
                gasLeft -= fuelConsumption;
            }
            System.out.println(this.name + " нужно заправиться.");
            recharge();
        }while (true);

    }

    protected void setName (String name){
        this.name=name;
    }
}
