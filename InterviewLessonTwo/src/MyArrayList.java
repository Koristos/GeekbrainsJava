import java.util.NoSuchElementException;

public class MyArrayList<T> {
    private T[] array;
    private int length = 0;

    MyArrayList() {
        this.array = (T[]) new Object[8];
    }

    public int getLength() {
        return this.length;
    }

    public void add(T objectToAdd) {
        if (isExpansionNeeded()) {
            doExpansion();
        }
        this.array[this.length] = objectToAdd;
        this.length++;
    }

    public void remove(T objectToRemove) {
        removeByIndex(indexOf(objectToRemove));
    }

    public void removeByIndex(int index) {
        this.array[index] = null;
        normalize();
        this.length--;
    }

    public int indexOf(T object) {
        for (int i = 0; i < this.length; i++) {
            if (this.array[i].equals(object)) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public T get(int index) {
        if (index >= this.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    private boolean isExpansionNeeded() {
        return this.length == this.array.length;
    }

    private void doExpansion() {
        T[] biggerArray = (T[]) new Object[this.array.length * 2];
        System.arraycopy(this.array, 0, biggerArray, 0, this.length);
        this.array = biggerArray;
    }

    private void normalize() {
        for (int i = 0; i < this.length; i++) {
            if (this.array[i] == null) {
                this.array[i] = this.array[i + 1];
                this.array[i + 1] = null;
            }
        }
    }
}
