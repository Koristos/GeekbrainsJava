package Polymorf;

public class Rectangle extends Quadrilateral{

    Rectangle (int height, int length){
        super(height, length, height, length);
    }
    @Override
    public int getSquare() {
        return (firstSide*secondSide);
    }

    @Override
    public int getBorderLength() {
        return (2*(firstSide+secondSide));
    }
}
