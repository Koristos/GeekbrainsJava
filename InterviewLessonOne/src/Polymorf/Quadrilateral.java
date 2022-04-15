package Polymorf;

public class Quadrilateral extends Form {
    int firstSide;
    int secondSide;
    int thirdSide;
    int fourthSide;

    Quadrilateral (int firstSide, int secondSide, int thirdSide, int fourthSide){
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.fourthSide = fourthSide;
    }

    @Override
    public int getSquare() {
        return 0; //тут должна была быть формула расчета площади четырехугольника
    }

    @Override
    public int getBorderLength() {
        return 0;
    }
}
