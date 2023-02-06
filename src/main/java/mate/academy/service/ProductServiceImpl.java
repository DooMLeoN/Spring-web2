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

    @Override
    public Product getById(Long id) {
        return productDao.getById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Product> getByBrand(String brand) {
        return productDao.getAllByBrand(brand);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
