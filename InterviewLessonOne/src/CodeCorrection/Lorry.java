package CodeCorrection;

/*class Lorry extends Car, Moveable, Stopable{

    public void move(){
        System.out.println("Car is moving");
    }

    public void stop(){
        System.out.println("Car is stop");
    }
}*/

class Lorry extends  Car implements Moveable, Stopable{

    @Override
    void open() {
        
    }

    @Override
    public void move() {

    }

    @Override
    public void stop() {

    }
}

