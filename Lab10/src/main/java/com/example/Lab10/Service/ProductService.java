package com.example.Lab10.Service;

import com.example.Lab10.Model.Product;
import com.example.Lab10.Repository.ProductRepository;
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

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public Product updateProductPartial(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }
        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }
        if (product.getPrice() != 0) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getIllustration() != null) {
            existingProduct.setIllustration(product.getIllustration());
        }
        return productRepository.save(existingProduct);
    }

    public boolean deleteProduct(Long id) {
        if(productRepository.findById(id).isEmpty()) {
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
}
