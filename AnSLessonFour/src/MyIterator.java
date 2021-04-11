import java.util.Iterator;
import java.util.function.Consumer;

class MyIterator<T> implements Iterator <T>{

    private MyLinkedListRealisation <T> list;
    private MyListElement<T> currentElement;

    MyIterator(MyLinkedListRealisation toIterate){
        this.list=toIterate;
        this.currentElement=toIterate.getListStart();
    }

    @Override
    public boolean hasNext() {
        if (this.currentElement==null) return false;
        else return true;
    }

    @Override
    public T next() {
        T value = this.currentElement.getValue();
        if(this.currentElement.hasNext()){
            this.currentElement=this.currentElement.getNext();
        }else this.currentElement=null;
        return value;
    }

    @Override
    public void remove() {
        MyListElement<T> toRemove = this.currentElement.getPrevious();
        toRemove.getPrevious().setNext(this.currentElement);
        this.currentElement.setPrevious(toRemove.getPrevious());
        this.list.setSize(this.list.size()-1);
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        while (hasNext()){
            action.accept(next());
        }
    }

    public void reset (){
        this.currentElement = list.getListStart();
    }

    public void insertAfter (T element){
        if(this.currentElement==null)this.list.insertLast(element);
        else {
            MyListElement<T> cursor = this.currentElement.getPrevious();
            MyListElement<T> toAdd = new MyListElement<T>(element, this.currentElement, cursor);
            this.currentElement.setPrevious(toAdd);
            cursor.setNext(toAdd);
        }
        this.list.setSize(this.list.size()+1);

    }

    public void insertBefore (T element){
        if(this.currentElement.getPrevious()==null)this.list.insertFirst(element);
        else {
            MyListElement<T> right = this.currentElement.getPrevious();
            MyListElement<T> left = right.getPrevious();
            MyListElement<T> toAdd = new MyListElement<T>(element, right, left);
            left.setNext(toAdd);
            right.setPrevious(toAdd);
        }
        this.list.setSize(this.list.size()+1);
    }
}


