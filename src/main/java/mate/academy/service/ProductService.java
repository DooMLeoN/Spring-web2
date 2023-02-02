package mate.academy.service;

import mate.academy.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product add(Product user);

    List<Product> getAll();

    Product getById(Long id);

    List<Product> getByBrand(String brand);

    void delete(Long id);
}
