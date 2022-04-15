public class MyGreetingMaker implements GreetingsMaker{
    @Override
    public String makeGreeting(String name) {
        return "Привет, "+name;
    }
}
