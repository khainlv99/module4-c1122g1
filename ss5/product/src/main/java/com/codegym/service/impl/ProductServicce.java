package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicce implements IProductService {
    private final IProductRepository repository;

    public ProductServicce(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteByID(Integer id) {
        repository.deleteByID(id);
    }

    @Override
    public void create(Product product) {
        repository.create(product);
    }

    @Override
    public Product findByID(Integer id) {
        return repository.findByID(id);
    }


    @Override
    public List<Product> searchByName(String name) {
        return repository.searchByName(name);
    }

    @Override
    public void edit(Product product) {
        repository.edit(product);
    }
}
