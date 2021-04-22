package ru.geekbrains.SpringLessonOne;

public class Product {
    int id;
    String name;
    double value;

    Product(int id, String name, double value){
        this.id=id;
        this.name=name;
        this.value=value;
    }

    @Override
    public String toString() {
        return String.format("%1d    -    %2s    ->   %3f денег", id,name,value);
    }
}
