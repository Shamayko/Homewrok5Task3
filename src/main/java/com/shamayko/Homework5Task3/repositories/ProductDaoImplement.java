package com.shamayko.Homework5Task3.repositories;

import com.shamayko.Homework5Task3.data.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import java.util.List;

@Component
public class ProductDaoImplement implements ProductDao {
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImplement(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public List<Product> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session
                    .createQuery("select p from Product p where p.id = :id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }


    @Override
    public void nullById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("select p from Product p where p.id =: id", Product.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.createQuery("update Product p set p.quantity =:quantity where p.id = :productId")
                    .setParameter("quantity", 0)
                    .setParameter("productId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }


    @Override
    public Float sumByProduct(Long id) {
        Float sum = findById(id).getQuantity() * findById(id).getCost();
        return sum;
    }

    @Override
    public Float sumByCart() {
        Float cartSum = 0.0f;
        for (Product p : findAll()) {
            cartSum += sumByProduct(p.getId());
        }
        return cartSum;
    }

    @Override
    public void changeQuantity(Long productId, Integer delta) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("select p from Product p where p.id =: id", Product.class)
                    .setParameter("id", productId)
                    .getSingleResult();
            session.createQuery("update Product p set p.quantity =:quantity where p.id = :productId")
                    .setParameter("quantity", product.getQuantity() + delta)
                    .setParameter("productId", productId)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

}
