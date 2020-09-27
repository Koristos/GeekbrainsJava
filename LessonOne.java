//Все сделал
public class LessonOne {
    public static void main (String[] args){
        byte myByte=2;
        short myShort=300;
        int myInt=2000000;
        long myLong=989898988;
        float myfloat= 0.1F;
        double myDouble=35.698;
        String myString="Привет!";
        char myChar=64;
        boolean myBoolean=false;

        System.out.println("Результат задания 3: "+ taskThree(2,0.5,15,5));
        System.out.println("Результат задания 4: "+ taskFour(2,5));
        taskFive(-10);
        System.out.println("Результат задания 6: "+ taskSix(2));
        taskSeven("Егор");
        taskEight(2020);


    }
    static double taskThree (double a, double b, double c, double d){
        return (a*(b+(c/d)));
    }

    static boolean taskFour(int a, int b){
        if ((a+b)<=20 && (a+b)>=10)return true;
        else return false;
    }

    static void taskFive(int a){
        if (a>=0) System.out.println("Результат задания 5:Переданное число положительное");
        else System.out.println("Результат задания 5:Переданное число отрицательное");
    }

    static boolean taskSix (int a){
        if (a<0) return true;
        else return false;
    }

    static void taskSeven(String a){
        System.out.println ("Резултат задания 7: Привет, "+a+"!");
    }

    static void taskEight(int a){
        if ((a%4==0 && a%100!=0)||a%400==0)System.out.println("Результат задания 8: год високосный");
        else System.out.println("Результат задания 8: год не високосный");
    }
}
