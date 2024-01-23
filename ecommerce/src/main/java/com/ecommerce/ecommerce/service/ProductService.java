package com.ecommerce.ecommerce.service;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Long productId, Product updatedProduct) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());


            productRepository.save(existingProduct);
        }
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}

