package shop.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProductRepositoryPostprocessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ProductRepository) {
            System.out.println("Загрузка продукции на склад...");
            ((ProductRepository) bean).setDefaultContent();
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
