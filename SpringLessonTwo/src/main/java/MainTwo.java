import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shop.spring.ShopConfig;
import shop.spring.UserInterface;

public class MainTwo {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfig.class);
        context.getBean("userApp", UserInterface.class).run();

    }
}
