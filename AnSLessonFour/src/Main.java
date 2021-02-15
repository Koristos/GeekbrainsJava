import java.util.Iterator;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        MyLinkedListRealisation <String> list = new MyLinkedListRealisation<String>();
        System.out.println(list.isEmpty());
        System.out.println(list.getFirst());
        list.insertFirst("1");
        list.insertFirst("2");
        list.insertFirst("3");
        list.insertFirst("4");

        System.out.println(list.pullOutFirst());
        list.printList();
        System.out.println(list.contains("10"));
        System.out.println(list.contains("3"));
        list.delete("2");
        list.printList();
        System.out.println(list.pullOutFirst());
        list.insertFirst("2");
        list.insertFirst("3");
        list.insertFirst("4");
        list.insertFirst("5");
        list.printList();

        Iterator iterator=list.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println("!!!");
        iterator.forEachRemaining(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });


        System.out.println(">>>>>");
        MyIterator it = (MyIterator) iterator;

        it.reset();
        it.insertBefore("111");
        System.out.println(it.next());
        System.out.println(it.next());
        it.insertAfter("111");
        System.out.println(it.next());
        it.remove();
        System.out.println(it.next());
        System.out.println(it.next());
        it.insertAfter("111");
        list.printList();

        MyLinkedListRealisation <Testy> tList = new MyLinkedListRealisation<Testy>();
        tList.insertFirst(new Testy(1));
        tList.insertFirst(new Testy(2));
        tList.insertFirst(new Testy(3));
        tList.insertFirst(new Testy(4));
        tList.insertFirst(new Testy(5));
        tList.printList();
        for (Testy a: tList) {
            a.sum(10);
        }
        tList.printList();


    }
}
