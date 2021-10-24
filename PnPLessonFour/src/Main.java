public class Main {
    public static void main(String[] args) {
        MyGreetingMakerProxy proxy = new MyGreetingMakerProxy();
        System.out.println(proxy.makeGreeting("Боб"));
    }
}
