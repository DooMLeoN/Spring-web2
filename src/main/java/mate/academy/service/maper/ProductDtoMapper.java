package mate.academy.service.maper;

import mate.academy.model.Product;
import mate.academy.model.dto.ProductRequestDto;
import mate.academy.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public ProductResponseDto pars(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setPrise(product.getPrise());
        responseDto.setBrand(product.getBrand());
        return responseDto;
    }

    public Product toProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setPrise(productRequestDto.getPrise());
        product.setBrand(productRequestDto.getBrand());
        return product;
    }
}
