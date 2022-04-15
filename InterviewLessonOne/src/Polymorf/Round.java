package Polymorf;

public class Round extends Form {
    int radius;

    Round (int radius){
        this.radius = radius;
    }

    @Override
    public int getSquare() {
        return 0; //Здесь должны быть формулы рассчета площади круга и дины окружности...
    }

    @Override
    public int getBorderLength() {
        return 0;
    }
}
