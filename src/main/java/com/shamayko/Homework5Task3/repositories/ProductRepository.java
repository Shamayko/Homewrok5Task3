package com.shamayko.Homework5Task3.repositories;

import com.shamayko.Homework5Task3.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Personal Happiness", 0, 99.99f),
                new Product(2L, "Communism", 0, 500f),
                new Product(3L, "Immortality", 0, 6.66f),
                new Product(4L, "PS 5", 0, 2.99f),
                new Product(5L, "Time machine", 0, 3.14f)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void nullById(Long id) {
        getProductById(id).setQuantity(0);
    }

    public Float sumByProduct(Long id) {
        Float sum = getProductById(id).getQuantity() * getProductById(id).getCost();
        return sum;
    }

    public Float sumByCart() {
        Float cartSum = 0.0f;
        for (Product p : getAllProducts()) {
            cartSum += sumByProduct(p.getId());
        }
        return cartSum;
    }


}
