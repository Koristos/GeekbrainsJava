import java.util.Locale;

public class MyGreetingMakerProxy implements GreetingsMaker {

    private final MyGreetingMaker maker = new MyGreetingMaker();

    @Override
    public String makeGreeting(String name) {
        Locale locale = Locale.getDefault();
        if (locale == Locale.ENGLISH){
            return translate(maker.makeGreeting(name), name);
        }
        return maker.makeGreeting(name);
    }

    private String translate(String message, String name) {
        return "Hello, "+name + " / " + message;
    }
}
