package shop.spring;

public interface Cart<T extends Product> {

    boolean add(T toAdd);

    boolean remove(int id);

    void showContent();

    void apply();

}
