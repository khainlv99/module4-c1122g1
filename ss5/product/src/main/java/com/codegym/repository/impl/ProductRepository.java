package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> productList = BaseRepository.entityManager.createQuery("select s from Product s", Product.class).getResultList();
        return productList;
    }

    public void deleteByID(Integer id_product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.createQuery("delete from Product where id = id_product", Product.class);
        entityTransaction.commit();
    }

    @Override
    public void create(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findByID(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = BaseRepository.entityManager.createQuery("select s from Product s where name_product like '%" + name + "%' ", Product.class).getResultList();
        return productList;
    }

    @Override
    public void edit(Product product) {

    }

}
