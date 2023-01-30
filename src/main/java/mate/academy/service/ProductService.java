package mate.academy.service;

import mate.academy.model.Product;

import java.util.List;

public interface ProductService {
    Product add(Product user);

    List<Product> getAll();
}
