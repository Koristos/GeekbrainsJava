public class MyDeque <T> {

    private T[] storage;
    private int leftPointer;
    private int rightPointer;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque(int size) {
        this.storage=(T[]) new Object[size];
        this.leftPointer=0;
        this.rightPointer=0;
        this.size=0;
    }

    public boolean insertRight(T value) {
        if (isFull()) return false;
        storage [rightPointer] = value;
        size++;
        if (rightPointer == storage.length - 1) {
            rightPointer = 0;
        }else rightPointer++;
        return true;
    }
    public boolean insertLeft(T value) {
        if (isFull()) return false;
        if (leftPointer == 0) {
            leftPointer = storage.length - 1;
        }else leftPointer--;
        storage [leftPointer] = value;
        size++;
        return true;
    }

    public T removeLeft() {
        if (isEmpty()) return null;
        T toRemove = storage[leftPointer];
        size--;
        if (leftPointer == storage.length - 1) {
            leftPointer = 0;
        }else leftPointer++;
        return toRemove;
    }

    public T removeRight() {
        if (isEmpty()) return null;
        if (rightPointer == 0) {
            rightPointer = storage.length - 1;
        }else rightPointer--;
        T toRemove = storage[rightPointer];
        size--;
        return toRemove;
    }

    public T peekLeft() {
        return storage[leftPointer];
    }

    public T peekRight() {
        int index;
        if(rightPointer==0)index=storage.length - 1;
        else index=rightPointer-1;
        return storage[index];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        if (leftPointer==rightPointer&&!(isEmpty())) return true;
        else return false;
    }
}
