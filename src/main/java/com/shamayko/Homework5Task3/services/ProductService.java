package com.shamayko.Homework5Task3.services;

import com.shamayko.Homework5Task3.data.Product;
import com.shamayko.Homework5Task3.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
 private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts (){return productRepository.getAllProducts(); }

    public void nullById (Long id) {productRepository.nullById(id); }

    public void changeQuantity(Long id, Integer delta) {
        Product product = productRepository.getProductById(id);
        product.setQuantity(product.getQuantity() + delta);
    }

    public Float totalCost() {return productRepository.sumByCart(); }
}
