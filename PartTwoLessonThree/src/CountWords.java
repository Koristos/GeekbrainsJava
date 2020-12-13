import java.util.HashMap;

public class CountWords {
private HashMap myMap = new HashMap();

public void countWords (String[] toCount){
   int temp;
    for (String currentWord:toCount){
if (this.myMap.containsKey(currentWord)==false){
    this.myMap.put(currentWord,1);
}else {
    temp = (int)this.myMap.get(currentWord);
    this.myMap.replace(currentWord,temp,temp+1);
}
    }
    System.out.println(this.myMap);
}

}
