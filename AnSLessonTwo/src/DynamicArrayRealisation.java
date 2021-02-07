import java.util.Arrays;

public class DynamicArrayRealisation<T extends Comparable<? super T>> {

    private int arraySize;
    private int filledSize;
    private T[] storage;
    private boolean isSorted;

    DynamicArrayRealisation (){
        this.arraySize=8;
        this.filledSize=0;
        this.storage= (T[])  new Comparable [arraySize];
        isSorted=false;
    }
    public void addElement(T toAdd) {
        if (filledSize>=(arraySize-1)){
            increaseSize();
        }
        storage[filledSize]=toAdd;
        filledSize++;
        isSorted=false;
    }

    public boolean removeElementById(int id) {
        if (id<0||id>filledSize) return false;
        System.arraycopy(storage, id+1, storage, id,(storage.length-id-1));
        storage[storage.length-1]=null;
        return true;
    }

    public T getElementById(int id) {
        if (id<0||id>filledSize) throw new RuntimeException("ID is not valid");
        return storage[id];
    }

    public int findElement(T toFind) {
        if (this.isSorted) return sortedSearch(toFind);
        return unsortedSearch(toFind);
    }

    public int getSize() {
        return this.filledSize;
    }

    public void sortInBubbleWay() {
        boolean wasChanged;
        do {
            wasChanged = false;
            for (int i = 0; i < filledSize-1; i++) {
                if (storage[i].compareTo(storage[(i +1)]) > 0) {
                    changeElements(i,i+1);
                    wasChanged = true;
                }
            }
        }while (wasChanged);
        this.isSorted=true;
    }

    public void sortInChoiceWay() {
        int increment = 0;
        do {
            int minValue=increment;
            int maxValue=increment;
            for (int i = increment; i < filledSize-increment; i++) {
                if(storage[minValue].compareTo(storage[i])>0)minValue=i;
                if(storage[maxValue].compareTo(storage[i])<0)maxValue=i;
            }
            changeElements(minValue,increment);
            changeElements(maxValue,filledSize-increment-1);
            increment++;
        }while (increment<(filledSize/2)+1);
        this.isSorted=true;
    }

    public void sortInPasteWay() {
        for (int i = 1; i < filledSize; i++) {
            T tempElem = storage[i];
            int currentPosition = i;
            while (currentPosition > 0 && compare(storage[currentPosition-1],storage[currentPosition]) >= 0) {
                storage[currentPosition] = storage[currentPosition - 1];
                currentPosition--;
            }
            storage[currentPosition] = tempElem;
        }
            this.isSorted=true;
    }


    public void printArray() {
        String toPrint="[";
        for (T a:storage) {
            if(a==null) {
                if(toPrint.length()>1){
                    toPrint=toPrint.substring(0,toPrint.length()-2);
                }
                break;
            }
            toPrint+=a+", ";
        }
        System.out.println(toPrint+"]");
    }


    private void increaseSize(){
        arraySize=arraySize*2;
        storage = Arrays.copyOf(storage,arraySize);
    }

    private int sortedSearch (T toFind){
        int min = 0;
        int max = filledSize-1;
        do {
            int middle = (max+min)/2;
            if(compare(toFind, storage[middle])==0) return middle;
            else if (compare(toFind, storage[middle])<0)max=middle-1;
            else if (compare(toFind, storage[middle])>0)min=middle+1;
        }while (min<=max);
        return -1;
    }
    private int unsortedSearch (T toFind){
        for (int i = 0; i < filledSize; i++) {
            if(storage[i]==toFind) return i;
        }
        return -1;
    }

    private int compare (T original, T countingPoint){
        return original.compareTo(countingPoint);
    }

    private void changeElements (int elemOne, int elemTwo){
        T temp = storage[elemOne];
        storage[elemOne]=storage[elemTwo];
        storage[elemTwo]=temp;
    }

}