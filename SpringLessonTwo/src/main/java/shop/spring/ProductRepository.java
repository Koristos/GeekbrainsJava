package shop.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("storage")
public class ProductRepository implements Repository<Product> {

    private final List<Product> storage;

    ProductRepository() {
        this.storage = new ArrayList<Product>();
    }

    @Override
    public boolean add(Product toAdd) {
        if (storage.contains(toAdd)) {
            return false;
        }
        storage.add(toAdd);
        return true;
    }

    @Override
    public Product getById(int id) {
        if (!emptyCheck()) {
            for (Product a : storage) {
                if (a.getId() == id) {
                    return a;
                }
            }
        }
        return null;
    }

    @Override
    public List<Product> getStorage() {
        emptyCheck();
        return storage;
    }

    private boolean emptyCheck() {
        if (storage.isEmpty()) {
            System.out.println("shop.spring.Product storage is empty");
            return true;
        }
        return false;
    }

    public void setDefaultContent() {
        add(new Product(1, "Apple", 2.50));
        add(new Product(2, "Banana", 3.50));
        add(new Product(3, "Orange", 3.10));
        add(new Product(4, "Plum", 1.80));
        add(new Product(5, "Peach", 2.10));
    }
}
