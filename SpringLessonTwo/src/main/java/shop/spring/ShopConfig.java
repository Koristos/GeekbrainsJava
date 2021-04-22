package shop.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("shop.spring")
public class ShopConfig {

    @Bean
    public UserInterface userApp(PurchaseController controller) {
        UserInterface userApp = new UserInterface();
        userApp.setController(controller);
        return userApp;
    }

    @Bean
    public ProductRepositoryPostprocessor storageInit() {
        return new ProductRepositoryPostprocessor();
    }
}

