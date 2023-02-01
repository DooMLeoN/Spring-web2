package mate.academy.service.maper;

import mate.academy.model.Product;
import mate.academy.model.dto.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public ProductResponseDto pars(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setPrise(product.getPrise());
        return responseDto;
    }
}
