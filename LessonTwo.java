import java.util.Random;
import java.util.Scanner;

public class LessonTwo {
    public static void main (String[] args){
        /*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
С помощью цикла и условия заменить 0 на 1, 1 на 0;
 */
        int [] testArray = new int[] {1,1,1,0,0,1,0};
        for (int i=0; i< testArray.length;i++){
            switch (testArray[i]){
                case 1: testArray[i]=0;
                break;
                case 0: testArray[i]=1;
                break;
            }
        }
        PrintArray(1,testArray);
 /*
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
 */
        int [] taskTwoArray = new int[8];
        for (int i=0; i< taskTwoArray.length; i++){
            taskTwoArray[i]=i*3;
        }
        PrintArray(2,taskTwoArray);
 /*
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
 */
        int[] taskThreeArray = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i=0;i<taskThreeArray.length;i++){
            if (taskThreeArray[i]<6){
                taskThreeArray[i]*=2;
            }
        }
        PrintArray(3,taskThreeArray);

 /*
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
заполнить его диагональные элементы единицами;
 */
        int taskFourArraySizze = 5;
        int[][] taskFourArray = new int[taskFourArraySizze][taskFourArraySizze];
        for (int i=0;i<taskFourArray.length;i++){
            taskFourArray[i][i]=1;
            taskFourArray[i][taskFourArray.length-i-1]=1;
        }
        PrintArray(4,taskFourArray);

/*
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
 */
        int[] taskFiveArray = new int[10];
        Random rnd = new Random();
        for (int i=0;i<taskFiveArray.length;i++){
            taskFiveArray[i]=rnd.nextInt(100);
        }
        int maxValue = taskFiveArray[0];
        int minValue = taskFiveArray[0];
        for (int a=0; a < taskFiveArray.length; a++){
            if (maxValue<taskFiveArray[a]) maxValue=taskFiveArray[a];
            if (minValue>taskFiveArray[a]) minValue=taskFiveArray[a];
        }
        System.out.println("Максимальное число в массиве - " + maxValue + "\n Минимальное число в массиве - " + minValue);
        PrintArray(5,taskFiveArray);


 /*
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1])
 → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
 */
        int[] taskSixArray=new int[]{1,2,3,2,5,10,3};
        isThereMiddle(taskSixArray);

 /*
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
 при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
 массивами.
 */
        int [] taskSevenArray=new int[]{1,2,3,4,5,6,7,8,9,0};
        taskSevenArray=moveArray((-5),taskSevenArray);
        PrintArray(7,taskSevenArray);


    }


    static void PrintArray (int taskNumber, int[] ArrayForPrint){
        String OutString="";
        for (int i=0;i< ArrayForPrint.length;i++){
            OutString = OutString+ArrayForPrint[i]+" ";
        }
        System.out.println ("Результат задания "+taskNumber+": "+OutString + "\n Нажмите ENTER, чтобы показать результат следующего задания");
        Scanner scan = new Scanner(System.in);
        OutString=scan.nextLine();

    }
    static void PrintArray (int taskNumber, int[][] ArrayForPrint){
        System.out.println ("Результат задания "+taskNumber);
        String OutString="";
        for (int i=0;i< ArrayForPrint.length;i++){
            for(int a=0;a< ArrayForPrint.length;a++) {
                OutString = OutString + ArrayForPrint[i][a] + " ";
            }
            System.out.println(OutString);
            OutString="";
        }
        System.out.println ("Нажмите ENTER, чтобы показать результат следующего задания");
        Scanner scan = new Scanner(System.in);
        OutString=scan.nextLine();

    }
    static boolean isThereMiddle (int [] arrayToCheck){
        int rightSum=0;
        int leftSum=0;
        String[] arrayToPrint = new String[]{"",""};
        int stringSwitcher=0;
        for (int i=0; i< arrayToCheck.length; i++){
            rightSum+=arrayToCheck[i];
        }
        for (int a=0;a<arrayToCheck.length;a++){
            leftSum+=arrayToCheck[a];
            arrayToPrint[stringSwitcher]+=" "+arrayToCheck[a];
            if (rightSum-leftSum==leftSum) {
                stringSwitcher=1;
            }
        }
        if (stringSwitcher==1){
            System.out.println("Задание 6: Массив делится на две равный части: [" +arrayToPrint[0]+" ||"+ arrayToPrint[1] + "]");
            return true;
        }else {
            System.out.println("Задание 6: Массив не делится на две равный части.");
            return false;
        }


    }

    static int[] moveArray(int step,int arrayToMove[]){
        int direction;
        if (step<0)direction= arrayToMove.length-1;
        else direction=0;

        for (int a=0;a<Math.abs(step)%arrayToMove.length;a++) {
            int stepNumber=arrayToMove[direction];
            for (int i = 0; i < arrayToMove.length - 1; i++) {
                if (step>=0) {
                    arrayToMove[i] = arrayToMove[direction + i+1];
                }
                else {
                    arrayToMove[direction-i] = arrayToMove[direction - i-1];
                }

            }
            arrayToMove[arrayToMove.length - 1-direction] = stepNumber;
        }

        return arrayToMove;
    }

}


