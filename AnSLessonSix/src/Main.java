import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int balanced=0;
        int unbalanced=0;
        int trees=20;

        LinkedList <MyTreeRealisation <Integer>> testTrees = new LinkedList<MyTreeRealisation<Integer>>();
        for (int i = 0; i < trees; i++) {
            testTrees.add(createTree());
        }

        for (MyTreeRealisation <Integer> a:testTrees) {
            a.display();
            if(a.isBalanced()) balanced++;
            else unbalanced++;
        }

        int balancePart = balanced*100/trees;

        System.out.println("Всего деревьев создано: "+trees+"\nИз низ сбалансировано: "+balanced
        +"("+balancePart+")  Не сбалансировано: "+ unbalanced+"("+(100-balancePart)+")");




    }

    public static MyTreeRealisation<Integer> createTree (){
        MyTreeRealisation <Integer> result = new MyTreeRealisation<Integer>();
        boolean full=true;
        Random rnd = new Random();
        while (full){
            full=result.add(rnd.nextInt(50)-25);

        }
        return result;
    }
}
