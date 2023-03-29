package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void addNew(Product product);
    void update(Product product);
    void remove(int id);
    Product findById(int id);
    List<Product> searchByName(String name);
}
