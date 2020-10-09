import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Employee {
    private GregorianCalendar birthDate= new GregorianCalendar();
    private String name;
    private String lastName;
    private String post;
    public String email;
    public String phone;
    public int salary;

    Employee(String name, String lastName, String dateOfBirth, String post, int salary, String email, String phone) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        this.name=name;
        this.lastName=lastName;
        this.post=post;
        this.salary=salary;
        this.email=email;
        this.phone=phone;
        this.birthDate.setTime(sdf.parse(dateOfBirth));

    }

    int GetAge(){
        int age=-1;
        if (this.birthDate.get(Calendar.DAY_OF_YEAR)<=GregorianCalendar.getInstance().get(Calendar.DAY_OF_YEAR)) age+=1;
        age+=GregorianCalendar.getInstance().get(Calendar.YEAR)-this.birthDate.get(Calendar.YEAR);
        return age;

    }

    void PrintData(){
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        String toPrint;
        String secondString;
        String thirdString;
        toPrint="ФИО: "+this.lastName+" "+this.name;
        toPrint=MakeStraight(toPrint);
        toPrint+="Дата рождения: "+ sdf.format(this.birthDate.getTime());
        secondString="Должность: "+post;
        secondString=MakeStraight(secondString);
        secondString+="Оклад: " + salary+ "\nКонтакты:";
        thirdString="Телфон: "+phone;
        thirdString=MakeStraight(thirdString);
        thirdString+="E-mail: " + email;
        System.out.println(toPrint+"\n"+secondString+"\n"+thirdString+"\n");


    }

    String MakeStraight(String input){
        int doStraight=40-input.length();
        for (int i=0; i<doStraight;i++){
            input+=" ";
        }
        return input;
    }


}
