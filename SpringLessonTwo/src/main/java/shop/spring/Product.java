package shop.spring;

import java.text.DecimalFormat;

public class Product {
    private final int id;
    private final String name;
    private final double rate;
    private final DecimalFormat numFormat;

    Product(int id, String name, double rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.numFormat = new DecimalFormat("#.00");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public String toString() {
        return String.format("ID: %1d --- %2s --- цена: %3s", this.id, this.name, this.numFormat.format(this.rate));
    }
}
