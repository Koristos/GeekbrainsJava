public class MyStack <T>{

    private int size;
    private T [] storage;

    @SuppressWarnings("unchecked")
    MyStack (int size){
        this.size=0;
        this.storage= (T[]) new Object[size];
    }

    public boolean push (T toPush){
        if(isFull()) return false;
        this.storage[size]=toPush;
        this.size++;
        return true;
    }

    public T pop (){
        return storage[--size];
    }

    public T peek (){
        return storage[size-1];
    }

    public int getSize(){
        return this.size;
    }

    public boolean isFull (){
        if (this.size==storage.length) return true;
        return false;
    }

    public boolean isEmpty (){
        if (this.size==0) return true;
        return false;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.size; i++) {
            sb.append(storage[i]);
            sb.append(", ");
        }
        if(sb.length()>1) sb.replace(sb.length()-2,sb.length(),"]");
        else sb.append("]");
        return sb.toString();
    }


}
