package com.shamayko.Homework5Task3.services;

import com.shamayko.Homework5Task3.data.Product;
import com.shamayko.Homework5Task3.repositories.ProductDaoImplement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
public ProductDaoImplement productDaoImplement;

    public ProductService(ProductDaoImplement productDaoImplement) {
        this.productDaoImplement = productDaoImplement;
    }

    public List<Product> getAllProducts (){return productDaoImplement.findAll(); }

    public void nullById (Long id) {productDaoImplement.nullById(id); }

    public void changeQuantity(Long id, Integer delta) {
        productDaoImplement.changeQuantity(id, delta);
    }

    public Float totalCost() {return productDaoImplement.sumByCart(); }

}
