public class PartTwoLessonThree {
    public static void main(String[] args) {
        String [] nameArray = new String[]{"ананас","арбуз","дыня","ананас","яблоко","арбуз","банан","виноград",
                "яблоко","ананас","груша","арбуз","ананас","персик","слива","банан","ананас","дыня","вишня",};

        CountWords count = new CountWords();
        count.countWords(nameArray);

        PhoneBook myBook = new PhoneBook();
        myBook.add("Иванов", 7777777);
        myBook.add("Иванов", 8888888);
        myBook.add("Петров", 3333333);
        myBook.add("Сидоров", 2222222);
        myBook.add("Иванов", 7777777);

        System.out.println(myBook.get("Иванов"));
        myBook.print();
    }


}
