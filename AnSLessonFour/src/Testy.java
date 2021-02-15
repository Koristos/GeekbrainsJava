public class Testy {
    int value;

    Testy (int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void setValue (int value){
        this.value=value;
    }

    public void sum (int append){
        value=value+append;
    }

    @Override
    public String toString (){
        return new String(""+value);
    }
}
