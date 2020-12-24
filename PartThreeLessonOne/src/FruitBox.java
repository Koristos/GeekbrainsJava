import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    private ArrayList <T> inside=new ArrayList<T>();

    public void addFruits (T fruitToAdd){
        this.inside.add(fruitToAdd);
    }

    public float getWeight(){
        float weight=0f;
        for (T a: this.inside) {
            weight+=a.getWeight();
        }
        return weight;
    }

    public boolean compareBoxWeight (FruitBox toCompare){
        return toCompare.getWeight()==this.getWeight();
    }

    public void transferToAnotherBox(FruitBox <T> toTransfer){
        for (T a: this.inside) {
            toTransfer.addFruits(a);
        }
        this.inside.clear();
    }
}
