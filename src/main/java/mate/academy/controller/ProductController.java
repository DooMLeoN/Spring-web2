package mate.academy.controller;

import mate.academy.model.Product;
import mate.academy.model.dto.ProductRequestDto;
import mate.academy.model.dto.ProductResponseDto;
import mate.academy.service.ProductService;
import mate.academy.service.maper.ProductDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;
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

    @GetMapping("/find")
    public List<ProductResponseDto> getByBrand(@RequestParam String brand) {
        return productService.getByBrand(brand)
                .stream()
                .map(productDtoMapper::pars)
                .collect(Collectors.toList());
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
    @PostMapping
    public ProductResponseDto create(@RequestBody ProductRequestDto productDto) {
        return productDtoMapper.pars(productService.add(productDtoMapper.toProduct(productDto)));
    }

    @GetMapping("/inject")
    public String injectMockData() {
        Product product = new Product("iPhone12",BigDecimal.valueOf(1999),"Apple");
        Product product1 = new Product("iPhone13",BigDecimal.valueOf(2500),"Apple");
        Product product2 = new Product("SamsungGalaxyS30",BigDecimal.valueOf(1800),"Samsung");
        productService.add(product1);
        productService.add(product2);
        productService.add(product);
        return "Done!";
    }
}
