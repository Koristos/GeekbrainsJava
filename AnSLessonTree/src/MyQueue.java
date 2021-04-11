public class MyQueue <T> {

    private T[] storage;
    private int outPointer;
    private int inPointer;
    private int size;

    @SuppressWarnings("unchecked")
    public MyQueue(int size) {
        this.storage=(T[]) new Object[size];
        this.outPointer=0;
        this.inPointer=0;
        this.size=0;
    }

    public boolean insert(T value) {
        if (isFull()) return false;
        storage [inPointer] = value;
        size++;
        if (inPointer == storage.length - 1) {
            inPointer = 0;
        }else inPointer++;
        return true;
    }

    public T remove() {
        if (isEmpty()) return null;
        T toRemove = storage[outPointer];
        size--;
        if (outPointer == storage.length - 1) {
            outPointer = 0;
        }else outPointer++;
        return toRemove;
    }

    public T peekHead() {
        return storage[outPointer];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        if (outPointer==inPointer&&!(isEmpty())) return true;
        else return false;
    }

}
