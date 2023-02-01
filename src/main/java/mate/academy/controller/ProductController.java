package mate.academy.controller;

import mate.academy.model.Product;
import mate.academy.model.dto.ProductResponseDto;
import mate.academy.service.ProductService;
import mate.academy.service.maper.ProductDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;
    @Autowired
    public ProductController(ProductService productService,
                             ProductDtoMapper productDtoMapper) {
        this.productService = productService;
        this.productDtoMapper = productDtoMapper;
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable Long id) {
        return productDtoMapper.pars(productService.getById(id));
    }
    @GetMapping("/")
    public List<ProductResponseDto> getAllProduct() {
        return productService.getAll()
                .stream()
                .map(productDtoMapper::pars)
                .collect(Collectors.toList());
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
        productService.add(iPhone2);
        return "Done!";
    }
}
