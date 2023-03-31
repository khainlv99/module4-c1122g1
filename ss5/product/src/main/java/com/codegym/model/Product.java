package com.codegym.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price", columnDefinition = "DOUBLE")
    private Double price;
    @Column(name = "type")
    private String type;
    @Column(name = "producer")
    private String producer;

    public Product() {
    }

    public Product(String name, Double price, String type, String producer) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.producer = producer;
    }

    public Product(Integer id, String name, Double price, String type, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
