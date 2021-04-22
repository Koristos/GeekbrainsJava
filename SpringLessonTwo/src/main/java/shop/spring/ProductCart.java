package shop.spring;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Component("cart")
public class ProductCart implements Cart<Product> {
    private final List<Product> productList;
    private final DecimalFormat numFormat;

    ProductCart() {
        this.productList = new ArrayList<Product>();
        this.numFormat = new DecimalFormat("#.00");
    }


    @Override
    public boolean add(Product toAdd) {
        if (productList.contains(toAdd) && toAdd != null) {
            return false;
        }
        productList.add(toAdd);
        return true;
    }

    @Override
    public boolean remove(int id) {
        if (!emptyCheck()) {
            for (Product a : productList) {
                if (a.getId() == id) {
                    productList.remove(a);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void showContent() {
        if (!emptyCheck()) {
            for (Product a : productList) {
                System.out.println(a.toString());
            }
        }
    }

    @Override
    public void apply() {
        if (!emptyCheck()) {
            double total = 0;
            for (Product a : productList) {
                total += a.getRate();
            }
            System.out.println(String.format("You confirmed a purchase of %1d products with total rate: %2s",
                    productList.size(), numFormat.format(total)));
        }
    }

    private boolean emptyCheck() {
        if (productList.isEmpty()) {
            System.out.println("Cart is empty");
            return true;
        }
        return false;
    }

}
