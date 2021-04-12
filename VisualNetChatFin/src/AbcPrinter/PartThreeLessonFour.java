package AbcPrinter;

public class PartThreeLessonFour {
    public static void main(String[] args) {
       AbcPrinter printer = new AbcPrinter();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                printer.printLetter('C','A');
                try {
                    Thread.sleep(120);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }}).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                printer.printLetter('B','C');
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }}).start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                printer.printLetter('A','B');
            }}).start();

    }
}
