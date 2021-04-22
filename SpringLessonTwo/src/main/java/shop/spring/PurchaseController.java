package shop.spring;

public interface PurchaseController {

    void viewProductList();

    void viewCartContent();

    void addProduct(int id);

    void removeProduct(int id);

    void confirmPurchase();

    void setCart(Cart<Product> cart);

    void setStorage(Repository<Product> repo);

}
