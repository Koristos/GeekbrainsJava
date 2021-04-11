public interface MyTree <T extends Comparable <? super T>>{

    enum TraverseMode {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER,
    }

    boolean add(T value);

    boolean contains(T value);

    boolean remove(T value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraverseMode mode);


}
