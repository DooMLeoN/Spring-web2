package mate.academy.dao;

import mate.academy.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product add(Product product);

    List<Product> getAll();

    Optional<Product> getById(Long id);

    List<Product> getAllByBrand(String brand);

    void delete(Long id);

    void update(Product product);
}
