package com.ecommerce.ecommerce.controller;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
        productService.updateProduct(productId, updatedProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }
}
