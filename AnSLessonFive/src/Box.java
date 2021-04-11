public class Box {
    private int weight;
    private int value;
    private String name;

    Box(int weight, int value, String name) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String toString (){
        return this.name+" вес: "+this.weight+" стоимость: "+this.value;
    }
}
