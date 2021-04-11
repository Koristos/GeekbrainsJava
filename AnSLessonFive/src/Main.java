import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(gradeNumber(3,5));
        LinkedList<Box> boxesToPack = new LinkedList<Box>();
        boxesToPack.add(new Box(5,1,"Кирпич"));
        boxesToPack.add(new Box(1,5,"Айфон"));
        boxesToPack.add(new Box(3,5,"Ноутбук"));
        boxesToPack.add(new Box(2,2,"Книга"));
        boxesToPack.add(new Box(3,2,"Сковородка"));
        boxesToPack.add(new Box(4,4,"Мясорубка"));

        for (Box a:packBackpack(10, boxesToPack)) {
            System.out.println(a.toString());
        }
    }

    static int gradeNumber (int number,int grade){
        if (grade==1) return number;
        if (grade<1)throw new RuntimeException("Grade can't be <1");
        int result=number*gradeNumber(number,grade-1);
        return result;
    }

    static LinkedList <Box> packBackpack (int capacity, LinkedList <Box> boxes){
        LinkedList <Box> result=new LinkedList<Box>();

        for (int i = 0; i < boxes.size(); i++) {
            LinkedList <Box> option =new LinkedList<Box>();
            LinkedList <Box> nBoxes =new LinkedList<Box>();
            nBoxes.addAll(boxes);
            option.add(boxes.removeFirst());
            if(capacity-option.peekFirst().getWeight()>=0) {
                option.add(nBoxes.removeFirst());
                option.addAll(packBackpack(capacity - option.peekFirst().getWeight(), nBoxes));
                if (getPackValue(option) > getPackValue(result)) result = option;
            }
            boxes.addLast(option.removeFirst());
        }

        return result;
    }

    static int getPackValue (LinkedList <Box> pack){
        int total=0;
        for (Box a:pack) {
            total+=a.getValue();
        }
        return total;
    }

}
