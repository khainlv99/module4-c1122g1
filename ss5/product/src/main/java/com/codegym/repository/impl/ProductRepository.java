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

    static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "Khai", 20.1, "Khai", "Khaideptrai"));
        productList.add(new Product(2, "Khai1", 20.1, "Khai1", "Khaideptrai1"));
        productList.add(new Product(3, "Khai2", 20.1, "Khai2", "Khaideptrai2"));
        productList.add(new Product(4, "Khai3", 20.1, "Khai3", "Khaideptrai3"));
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("select p from Product p" ,Product.class).getResultList();
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = BaseRepository.entityManager.createQuery("SELECT c FROM Product AS c WHERE c.id = :id",Product.class).setParameter("id",id).getSingleResult();
        return product;
    }

    @Override
    public void update(int id, Product product) {
        for (Product pro : productList) {
            if(pro.getId() == id){
                productList.set(productList.indexOf(pro),product);
            }
        }
    }

    @Override
    public void remote(int id) {
        productList.remove(findById(id));
    }
}
