package com.example.inventory_system.controller;

import com.example.inventory_system.model.Product;
import com.example.inventory_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Add a new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // Get low stock products
    @GetMapping("/low-stock")
    public List<Product> getLowStockProducts() {
        return productRepository.findByStockQuantityLessThan(10); // Or use product.getMinStock()
    }
}
