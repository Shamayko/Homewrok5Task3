package com.shamayko.Homework5Task3.controllers;

import com.shamayko.Homework5Task3.data.Product;
import com.shamayko.Homework5Task3.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/sum")
    public Float totalCost() {
        return productService.totalCost();
    }

    @GetMapping("/products/null/{id}")
    public void nullProduct(@PathVariable Long id) {
        productService.nullById(id);
    }

    @GetMapping("/products/change_quantity")
    public void changeQuantity(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeQuantity(productId, delta);
    }
}
