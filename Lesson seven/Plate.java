public class Plate {

    private int capacity;
    private int foodValume;

    Plate(){
        this.capacity=30;
        this.foodValume=0;
    }

    public boolean FillPlate(int food){
        if (food>0&&food<=this.capacity-this.foodValume){
            this.foodValume+=food;
            System.out.println("Вы положили еду в тарелку.");
            return true;
        }else {
            System.out.println("В эту тарелку не влезет столько еды.");
            return false;
        }
    }

    public int HowMuchFood(){
        System.out.println("В эту тарелку можно положить еще "+(this.capacity-this.foodValume)+" единиц еды.");
        return (this.capacity-this.foodValume);
    }

    public boolean Feed (int wantToEat){
        if(wantToEat<this.foodValume&&wantToEat>0) {
            this.foodValume-=wantToEat;
            return true;
        }else return false;
    }
}
