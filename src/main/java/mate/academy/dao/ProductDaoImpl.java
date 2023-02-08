package mate.academy.dao;

import java.util.List;
import java.util.Optional;

import mate.academy.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product add(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't save product to DB: " + product);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT p FROM Product p ",
                    Product.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all products from DB!");
        }
    }

    @Override
    public Optional<Product> getById(Long id) {
        try(Session session = sessionFactory.openSession()) {
            Product id1 = session.createQuery("SELECT p FROM Product p WHERE p.id =: id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return Optional.ofNullable(id1);
        } catch (Exception e) {
            throw new RuntimeException("Can't get product by id:" + id);
        }
    }

    @Override
    public List<Product> getAllByBrand(String brand) {
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT p FROM Product p WHERE p.brand =: brand", Product.class)
                    .setParameter("brand", brand)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all product by brand:" + brand);
        }
    }

    @Override
    public void delete(Long id) {
        try(Session session = sessionFactory.openSession()) {
            session.createQuery("DELETE FROM Product p WHERE p.id=:id",Product.class)
                    .setParameter("id",id);
        } catch (Exception e) {
            throw new RuntimeException("Can't delete product by id:" + id, e);
        }
    }

    @Override
    public void update( Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't update product session: " + product, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
