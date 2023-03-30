package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IProductRepository {
    void save(Product product);
    List<Product> findAll();
    Product findById(int id);
    void update(int id, Product product);
    void remote(int id);
}
