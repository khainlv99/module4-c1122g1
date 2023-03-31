package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void update(int id, Product product);
    Product findById(int id);
    void remote(int id);
}
