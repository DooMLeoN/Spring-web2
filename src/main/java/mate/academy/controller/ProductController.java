package mate.academy.controller;

import mate.academy.model.Product;
import mate.academy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    public final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productService.getAll();
    }

    @GetMapping("/inject")
    public String injectMockData() {
        Product iPhone = new Product();
        iPhone.setName("iPhone 1000");
        Product iPhone2 = new Product();
        iPhone.setName("iPhone 1000");
        iPhone.setPrise(BigDecimal.valueOf(94540));
        iPhone2.setName("iPhone 2000");
        iPhone2.setPrise(BigDecimal.valueOf(97846845));
        productService.add(iPhone);
        return "Done!";
    }
}
