package com.example.crudproject.service;

import com.example.crudproject.entity.Product;
import com.example.crudproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    //postMethod
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    //getMethod
    public List<Product> getProducts() {
        return repository.findAll();
    }
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    //for delete
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    //for update
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setNumber(product.getNumber());
        existingProduct.setAge(product.getAge());
        return repository.save(existingProduct);
    }



}
