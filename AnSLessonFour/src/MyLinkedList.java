public interface MyLinkedList <T> extends Iterable <T>{


    void insertFirst (T element);
    void insertLast (T element);
    T pullOutFirst();
    T pullOutLast();
    T getFirst();
    T getLast();
    boolean contains (T element);
    boolean delete (T element);
    int size ();
    boolean isEmpty ();
    void printList();

}

class MyListElement <T> {
    private T value;
    private MyListElement <T> next;
    private MyListElement <T> previous;

    MyListElement (T element, MyListElement<T> next, MyListElement previous){
        this.next = next;
        this.previous = previous;
        this.value = element;
    }


    protected T getValue() {
        return value;
    }

    protected MyListElement<T> getNext() {
        return next;
    }

    protected MyListElement<T> getPrevious() {
        return previous;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    protected void setNext(MyListElement<T> next) {
        this.next = next;
    }

    protected void setPrevious(MyListElement<T> previous) {
        this.previous = previous;
    }

    protected boolean hasNext(){
        return !(this.next==null);
    }

    protected boolean hasPrevious(){
        return !(this.previous==null);
    }
}
