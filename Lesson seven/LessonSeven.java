import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Scanner;

public class LessonSeven {
    static ArrayList <Cat> myCats=new ArrayList<>();
    static Plate myPlate = new Plate();


    public static void main(String[] args) {
        boolean goOn=true;
        System.out.println("Что-то скучно. Может завести кота? Только помни, коты часто хотят есть. Буквально каждые 30 секунд. Заводим? 1-Да 2-Нет");
        if (UserInput(2)==1) CreateCat();
        else goOn=false;
        while (goOn==true){
            System.out.println("\nЧто будем делать теперь?\n 1 - Завести еще кота \n 2 - Осмотреть котов \n 3 - Покормить одного кота \n 4 - Позвать всех котов кушать \n 5 - Положить еду в миску \n 6 - Надоело, я ухожу");
            int action = UserInput(6);
            if (action==1) CreateCat();
            if (action==2)ScanCats();
            if(action==3)FeedCat();
            if(action==4)FeedThemAll();
            if (action==5)FillThePlate();
            if (action==6)goOn=false;
        }
        System.out.println("Ну тогда пока!");

    }

    public static int UserInput(int options){
        Scanner scan = new Scanner(System.in);
        int result=0;
        String trash;
        do {
            if (scan.hasNextInt()){
                result=scan.nextInt();
            }else trash=scan.nextLine();
        }while (result<1&&result>options);
        return result;
    }

    public static void CreateCat(){
        Scanner scan=new Scanner(System.in);
        String catName;
        int namePossible=-1;
        System.out.println("Придумай имя для кота");
        do{
            catName=scan.nextLine();
            namePossible=HasThisName(catName);
            if(namePossible!=-1)System.out.println("Такой кот у вас уже есть. Придумайте другое имя!");
        }while (namePossible!=-1);
        myCats.add(new Cat(catName));
        System.out.println("У вас появился новый кот - "+catName+"!");
    }

    public static int HasThisName(String name){
        for (int i=0; i<myCats.size(); i++) {
            if (name.equals(myCats.get(i).GetName())) return i;
        }
        return -1;
    }
    public static void FeedCat(){
        Scanner scan=new Scanner(System.in);
        String catName;
        int namePossible=-1;
        System.out.println("Кого будем кормить?");
        do{
            catName=scan.nextLine();
            namePossible=HasThisName(catName);
            if(namePossible==-1)System.out.println("Тут нет такого кота!");
            else myCats.get(namePossible).Feed(myPlate);
        }while (namePossible==-1);

    }

    public static void FillThePlate(){
        int foodAmount;
        System.out.println("Сколько еды положить в миску?");
        do {
            myPlate.HowMuchFood();
            foodAmount = UserInput(1000000);
        }while (myPlate.FillPlate(foodAmount)==false);
    }

    public static void FeedThemAll(){
        for(int i=0; i<myCats.size();i++){
            myCats.get(i).Feed(myPlate);
        }
    }

    public static void ScanCats(){
        for(int i=0; i<myCats.size();i++){
            myCats.get(i).IsHungry();
        }
    }


}
