import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {
    private HashMap book = new HashMap();

    public void add (String name,int phoneNumber){
        this.book.putIfAbsent(phoneNumber,name);
    }
    public String get (String name){
        String result="";
        Iterator it = this.book.entrySet().iterator();
        while (it.hasNext()){
        Map.Entry temp = (Map.Entry) it.next();
        if (temp.getValue().equals(name)){
            result+="\n"+temp.getValue() + " - " + temp.getKey();
        }
        }
        return result;
    }

    public void print(){
        System.out.println(this.book);
    }
}
