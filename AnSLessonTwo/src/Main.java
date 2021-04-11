import java.util.Random;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long time;
        DynamicArrayRealisation <Integer> testArrayOne= new DynamicArrayRealisation<Integer>();
        DynamicArrayRealisation <Integer> testArrayTwo= new DynamicArrayRealisation<Integer>();
        DynamicArrayRealisation <Integer> testArrayThree= new DynamicArrayRealisation<Integer>();

        fillArrayWithRndInt(testArrayOne,100000);
        fillArrayWithRndInt(testArrayTwo,100000);
        fillArrayWithRndInt(testArrayThree,100000);

        Thread.sleep(20000);

        System.out.println("Пузырьковая сортировка начата.");
        time = System.currentTimeMillis();
        testArrayOne.sortInBubbleWay();
        System.out.println("Пузырьковая сортировка закончена. Времени затрачено: "+(System.currentTimeMillis()-time));

        System.out.println("Выборочная сортировка начата.");
        time = System.currentTimeMillis();
        testArrayTwo.sortInChoiceWay();
        System.out.println("Выборочная сортировка закончена. Времени затрачено: "+(System.currentTimeMillis()-time));

        System.out.println("Сортировка вставкой начата.");
        time = System.currentTimeMillis();
        testArrayThree.sortInPasteWay();
        System.out.println("Сортировка вставкой закончена. Времени затрачено: "+(System.currentTimeMillis()-time));


    }

    public static void fillArrayWithRndInt (DynamicArrayRealisation array, int length){
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            array.addElement(rnd.nextInt(100));
        }
    }
}
