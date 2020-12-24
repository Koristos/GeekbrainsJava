import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PartThreeLessonOne {

    public static void main(String[] args) {

        String [] testArray = new String[]{"Один","Два","Три","Четыре","Пять","Шесть","Семь"};

        System.out.println(Arrays.toString(testArray));
        System.out.println(Arrays.toString(randomChange(testArray)));
        ArrayList<String> testList = getArrayList(testArray);
        System.out.println(testList);

        FruitBox <Orange> orangeBoxOne = new FruitBox<Orange>();
        FruitBox <Orange> orangeBoxTwo = new FruitBox<Orange>();
        FruitBox <Apple> appleBox = new FruitBox<Apple>();

        for (int i=0; i<10;i++){
            orangeBoxOne.addFruits(new Orange());
            appleBox.addFruits(new Apple());
        }

        for (int i=0; i<5;i++){
            orangeBoxTwo.addFruits(new Orange());
        }

        System.out.println("\nПервая коробка апельсинов - "+orangeBoxOne.getWeight()+
                "\nВторая коробка апельсинов - "+orangeBoxTwo.getWeight()+
                "\nКоробка яблок - "+appleBox.getWeight());

        System.out.println(orangeBoxTwo.compareBoxWeight(appleBox));

        orangeBoxOne.transferToAnotherBox(orangeBoxTwo);

        System.out.println("\nПервая коробка апельсинов - "+orangeBoxOne.getWeight()+
                "\nВторая коробка апельсинов - "+orangeBoxTwo.getWeight()+
                "\nКоробка яблок - "+appleBox.getWeight());
        System.out.println(orangeBoxTwo.compareBoxWeight(appleBox));




    }

    public static <T> T[] randomChange (T[] inputArray){
        int firstCell;
        int secondCell;
        T temp;
        Random rnd = new Random();
        firstCell = rnd.nextInt(inputArray.length);
        do {
            secondCell = rnd.nextInt(inputArray.length);
        }while (firstCell==secondCell);
        temp=inputArray[firstCell];
        inputArray[firstCell]=inputArray[secondCell];
        inputArray [secondCell]=temp;
        return inputArray;
    }

    public static <T> ArrayList<T> getArrayList(T[] inputArray){
        ArrayList<T> toReturn = new ArrayList<T>(Arrays.asList(inputArray));
        return toReturn;
    }
}
