package com.example.thymeleaf.repository;

import com.example.thymeleaf.entity.Product;

import java.util.List;

public interface IProductRepossitory {
    List<Product> findAll();
    void addNew(Product product);
    void update(Product product);
    void remove(int id);
    Product findById(int id);
    List<Product>searchByName(String name);
}
