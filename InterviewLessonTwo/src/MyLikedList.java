import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class MyLikedList <T> {

    private class Container <T>{
        private T object;
        private Container <T> next;
        private Container <T> previous;

        private T getObject() {
            return object;
        }

        private void setObject(T object) {
            this.object = object;
        }

        private Container<T> getNext() {
            return next;
        }

        private void setNext(Container<T> next) {
            this.next = next;
        }

        private Container<T> getPrevious() {
            return previous;
        }

        private void setPrevious(Container<T> previous) {
            this.previous = previous;
        }
    }

    private int size = 0;
    private Container<T> first = null;
    private Container<T> last = null;
    private Container<T> current = null;

    public void add (T objectToAdd){
        Container<T> container = new Container<>();
        container.setObject(objectToAdd);
        container.setNext(null);
        container.setPrevious(this.last);
        if (this.last != null){
            this.last.setNext(container);
        }
        this.last = container;
        if (this.first == null){
            this.first = container;
            this.current = container;
        }
        this.size++;
    }

    public void insertAfter (T object){
        if (!hasNext()){
            add(object);
        }else {
            Container<T> container = new Container<>();
            container.setObject(object);
            container.setNext(this.current.getNext());
            this.current.getNext().setPrevious(container);
            this.current.setNext(container);
            container.setPrevious(this.current);
            size++;
        }

    }

    public void insertBefore (T object){
        Container<T> container = new Container<>();
        container.setObject(object);
        if (!hasPrevious()){
            this.first = container;
            container.setPrevious(null);
        }else {
            this.current.getPrevious().setNext(container);
            container.setPrevious(this.current.getPrevious());
        }
        this.current.setPrevious(container);
        container.setNext(this.current);
        size++;

    }

    public void deleteCurrent(){
        this.current.getPrevious().setNext(this.current.getNext());
        this.current.getNext().setPrevious(this.current.previous);
        this.current = this.current.getNext();
        size--;
    }

    public T getFirst (){
        if (this.first== null){
            throw new NoSuchElementException();
        }
        this.current=this.first;
        return this.first.getObject();
    }

    public T  getLast (){
        if (this.last== null){
            throw new NoSuchElementException();
        }
        this.current = this.last;
        return this.last.getObject();
    }

    public T getCurrent(){
        if (this.current== null){
            throw new NoSuchElementException();
        }
        return this.current.getObject();
    }

    public  boolean contains (T objectToFind){
        if (this.size==0){
            return false;
        }
        this.current = this.first;
        do {
            if(current.getObject().equals(objectToFind)){
                return true;
            }
            if (hasNext()){
                this.current = current.getNext();
            }
        }while (hasNext());
        return false;
    }

    public int getSize (){
        return this.size;
    }

    public void forEach(Consumer action) {
        Objects.requireNonNull(action);
        if (this.first==null){
            return;
        }
        this.current = this.first;
        do {
            action.accept(this.current.getObject());
            if (hasNext()){
                this.current = this.current.getNext();
            }
        }while (hasNext());
    }

    public boolean hasNext (){
        if (this.current.getNext() != null){
            return true;
        }
        return false;
    }

    public boolean hasPrevious(){
        if (this.current.getPrevious() != null){
            return true;
        }
        return false;
    }

    public T next (){
        this.current = this.current.getNext();
        return this.current.getObject();
    }

    public T previous (){
        this.current = this.current.getPrevious();
        return this.current.getObject();
    }


}
