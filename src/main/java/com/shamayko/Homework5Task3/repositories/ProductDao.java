package com.shamayko.Homework5Task3.repositories;

import com.shamayko.Homework5Task3.data.Product;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    List<Product> findAll();
    Float sumByProduct(Long id);
    Float sumByCart();
    void nullById(Long id);
    void changeQuantity(Long productId, Integer delta);

}
