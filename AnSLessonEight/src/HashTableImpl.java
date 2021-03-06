
import java.util.Arrays;
import java.util.LinkedList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    private LinkedList<Item<K,V>>[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableImpl(int maxSize) {
        this.data = new LinkedList[maxSize*2];
        for (int i = 0; i < this.data.length; i++) {
            data[i]=new LinkedList<Item<K,V>>();
        }
    }

    private int hashFunc(K key) {
        //System.out.println("Hash: "+key.hashCode()+" Length: "+data.length +" Index: "+(key.hashCode()% data.length));
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        if (!data[index].isEmpty()) {
            for (Item <K,V> a:data[index]) {
                if(a.getKey().equals(key)) {
                    a.setValue(value);
                    return true;
                }
            }
        }

        data[index].add(new Item<>(key, value));
        size++;
        return true;
    }


    @Override
    public V get(K key) {
        int index = hashFunc(key);
        for (Item<K,V> a:data[index]) {
            if (a.getKey().equals(key))
                return a.getValue();
        }
        return null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);
        while (!data[index].isEmpty()) {
            for (Item <K,V> a:data[index]) {
                if(a.getKey().equals(key)) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        for (Item<K,V> a: data[index]) {
            if(a.getKey().equals(key)) {
                size--;
                data[index].remove(a);
                return a.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]", i, Arrays.toString(data[i].toArray()));
            System.out.println();
        }
        System.out.println("----------");
    }


}
