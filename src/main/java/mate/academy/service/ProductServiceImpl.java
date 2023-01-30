package mate.academy.service;

import java.util.List;

import mate.academy.dao.ProductDao;
import mate.academy.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product add(Product user) {
        return productDao.add(user);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}