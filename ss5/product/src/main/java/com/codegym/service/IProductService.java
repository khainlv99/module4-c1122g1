package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void deleteByID(Integer id);

    void create(Product product);

    Product findByID(Integer id);

    List<Product> searchByName(String name);

    void edit(Product product);
}
