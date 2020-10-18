import java.text.ParseException;

public class LessonFive {
    public static void main(String[] args) throws ParseException {

       Employee[] empList=new Employee[5];
       empList[0]= new Employee("Иван", "Крузенштерн", "15.12.1980", "Человек и пароход", 100, "kruzenshtern@mail.ru", "8-800-200-00-00");
       empList[1]= new Employee("Христофор", "Врунгель", "01.05.1980", "Капитан", 120, "vrungel@mail.ru", "8-800-200-50-50");
       empList[2]= new Employee("Тони", "Старк", "15.11.1975", "гений, филантроп", 1000000, "stark@mail.ru", "8-800-255-35-15");
       empList[3]= new Employee("Кузя", "Домовенок", "01.06.2000", "Домовой", 5000, "kuzma@mail.ru", "8-800-555-55-00");
       empList[4]= new Employee("Дейенерис", "Таргариен", "30.01.1999", "Мать драконов", 17000, "drakaris@mail.ru", "8-800-305-34-44");

       for (int i=0; i<empList.length;i++){
           if (empList[i].GetAge()<40) empList[i].PrintData();
       }


    }
}