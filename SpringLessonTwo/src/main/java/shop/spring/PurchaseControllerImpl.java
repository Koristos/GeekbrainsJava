package shop.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("controller")
public class PurchaseControllerImpl implements PurchaseController {

    private Repository<Product> storage;
    private Cart cart;

    PurchaseControllerImpl() {
    }

    PurchaseControllerImpl(ProductCart cart, ProductRepository storage) {
        this.storage = storage;
        this.cart = cart;
    }

    @Autowired
    public PurchaseControllerImpl(Repository<Product> storage, Cart cart) {
        this.storage = storage;
        this.cart = cart;
    }

    @Override
    public void viewProductList() {
        System.out.println("Товары на складе:");
        for (Product a : this.storage.getStorage()) {
            System.out.println(a.toString());
        }
        System.out.println("***************");
    }

    @Override
    public void viewCartContent() {
        this.cart.showContent();

    }

    @Override
    public void addProduct(int id) {
        try {
            if (this.storage.getById(id).toString() != null) {
                if (this.cart.add(this.storage.getById(id))) {
                    System.out.println("Продукт успешно добавлен");
                }
            } else {
                System.out.println("Не удалось добавить продукт. Повторите попытку позже.");
            }
        } catch (NullPointerException e) {
            System.out.println("Не удалось добавить продукт. Проверьте правильность ID");
        }

    }

    @Override
    public void removeProduct(int id) {
        if (this.cart.remove(id)) {
            System.out.println("Продукт успешно удален");
        } else {
            System.out.println("Не удалось удалить продукт. Проверьте правильность ID");
        }

    }

    @Override
    public void confirmPurchase() {
        this.cart.apply();
        this.cart = new ProductCart();
    }

    @Override
    public void setCart(Cart<Product> cart) {
        this.cart = cart;
    }

    @Override
    public void setStorage(Repository<Product> repo) {
        this.storage = repo;
    }
}
