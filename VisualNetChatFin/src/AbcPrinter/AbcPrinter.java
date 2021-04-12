package AbcPrinter;

@SuppressWarnings("SynchronizeOnNonFinalField")
public class AbcPrinter {
    private volatile char nextToPrint='A';

    public synchronized void printLetter (char toPrint, char flagToSet){
        try {
            while (nextToPrint!=toPrint) {
                wait();
            }
            System.out.print(toPrint);
            this.nextToPrint=flagToSet;
            notifyAll();
        }catch (InterruptedException e){
            throw new RuntimeException("SWW in printLetter"+toPrint);
        }
    }
}

