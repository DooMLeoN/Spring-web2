package mate.academy.controller;

import mate.academy.model.Product;
import mate.academy.model.dto.ProductRequestDto;
import mate.academy.model.dto.ProductResponseDto;
import mate.academy.service.ProductService;
import mate.academy.service.maper.ProductDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody ProductRequestDto requestDto) {
        Product product = productDtoMapper.toProduct(requestDto);
        product.setId(id);
        Product update = productService.update(product);
        return productDtoMapper.pars(update);
    }
}
