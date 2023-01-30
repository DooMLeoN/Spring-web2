package mate.academy;

import mate.academy.config.AppConfig;
import mate.academy.model.Product;
import mate.academy.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService bean = context.getBean(ProductService.class);
        Product iPhone = new Product();
        iPhone.setName("iPhone 1000");
        Product iPhone2 = new Product();
        iPhone.setName("iPhone 1000");
        iPhone.setPrise(BigDecimal.valueOf(94540));
        bean.add(iPhone);
        bean.add(iPhone2);
        System.out.println(bean.getAll());
    }
}
