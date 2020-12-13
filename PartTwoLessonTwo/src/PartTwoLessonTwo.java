public class PartTwoLessonTwo {
    public static void main(String[] args) {
        String[][] goodArray = {{"1", "2", "3", "1"},{"1","2","3","1"},{"1","2","3","1"},{"1","2","3","1"}};
        String[][] wrongArrayA = {{"1", "2", "3", "1","1"},{"1","2","3","1","1"},{"1","2","3","1","1"},{"1","2","3","1","1"}};
        String[][] wrongArrayB = {{"1", "2", "3", "g"},{"1","2","3","1"},{"1","2","h","1"},{"1","2","i","1"}};

        Process doIt = new Process();
        try {
            doIt.process(goodArray);
            doIt.process(wrongArrayB);
            doIt.process(wrongArrayA);
        }catch (MyArraySizeException|MyArrayDataException e){
            e.printStackTrace();
        }



    }
}
