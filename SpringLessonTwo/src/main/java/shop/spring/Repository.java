package shop.spring;

import java.util.List;

public interface Repository<T extends Product> {
    boolean add(T toAdd);

    T getById(int id);

    List<T> getStorage();

}
