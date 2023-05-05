package main.shopping.service;

import main.shopping.entity.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void remove(Product product);
    Product findById(int id);
    List<Product> findAll();
}
