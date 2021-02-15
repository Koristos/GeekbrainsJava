import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedListRealisation <T> implements MyLinkedList <T> {

    private int size;
    private MyListElement<T> first;
    private MyListElement<T> last;

    MyLinkedListRealisation (){
        this.size=0;
        first=null;
        last=null;
    }

    @Override
    public void insertFirst(T element) {
        MyListElement<T> newElement =new MyListElement<T>(element, this.first, null);
        if (isEmpty()){
            this.first=newElement;
            this.last=newElement;
        }else {
            this.first.setPrevious(newElement);
            this.first = newElement;
        }
        this.size++;
    }

    @Override
    public void insertLast(T element) {
        MyListElement<T> newElement =new MyListElement<T>(element, null, this.last);
        if (isEmpty()){
            this.first=newElement;
            this.last=newElement;
        }else {
            this.last.setNext(newElement);
            this.last = newElement;
        }
        this.size++;
    }

    @Override
    public T pullOutFirst() {
        if(isEmpty()) return null;
        T value = first.getValue();
        this.first = this.first.getNext();
        this.first.setPrevious(null);
        this.size--;
        return value;
    }

    @Override
    public T pullOutLast() {
        if(isEmpty()) return null;
        T value = last.getValue();
        this.last = this.last.getPrevious();
        this.last.setNext(null);
        this.size--;
        return value;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) return null;
        return (T) this.first.getValue();
    }

    @Override
    public T getLast() {
        if (isEmpty()) return null;
        return this.last.getValue();
    }

    @Override
    public boolean contains(T element) {
        for (T a: this) {
            if(a.equals(element)) return true;
        }
        return false;
    }

    @Override
    public boolean delete(T element) {
        MyIterator iterator = new MyIterator(this);
        while (iterator.hasNext()){
            if(iterator.next().equals(element)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size==0);
    }

    @Override
    public void printList() {
        StringBuilder sb = new StringBuilder("\n******");
        for (T a: this) {
            sb.append("\n"+a);
        }
        sb.append("\n******");
        System.out.println(sb.toString());

    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        MyListElement<T> current = this.first;
        while (current!=null){
            action.accept(current.getValue());
            current=current.getNext();
        }
    }
    protected MyListElement <T> getListStart(){
        return this.first;
    }
    protected void setSize (int size){
        this.size=size;
    }
}



