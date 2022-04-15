public class Main {
    public static void main(String[] args) {
        QueueHandler handler = new QueueHandler();
        handler.registerProcessor(new Processor());
        handler.registerProcessor(new Processor());
        handler.registerProcessor(new Processor());
        handler.add("1 String");
        handler.add("2 String");
        handler.add("3 String");
        handler.add("4 String");
        handler.add("5 String");
        handler.add("6 String");
        handler.add("7 String");
        handler.add("8 String");
        handler.add("9 String");
        handler.add("10 String");
        handler.add("11 String");
        handler.add("12 String");
        handler.execute();


    }
}
