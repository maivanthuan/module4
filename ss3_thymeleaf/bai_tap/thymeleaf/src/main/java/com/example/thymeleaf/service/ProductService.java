package com.example.thymeleaf.service;

import com.example.thymeleaf.entity.Product;
import com.example.thymeleaf.repository.IProductRepossitory;
import com.example.thymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepossitory  iProductRepossitory;
    @Override
    public List<Product> findAll() {
        return iProductRepossitory.findAll();
    }

    @Override
    public void addNew(Product product) {
        iProductRepossitory.addNew(product);
    }

    @Override
    public void update(Product product) {
        iProductRepossitory.update(product);
    }

    @Override
    public void remove(int id) {
        iProductRepossitory.remove(id);
    }

    @Override
    public Product findById(int id) {
        return iProductRepossitory.findById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return iProductRepossitory.searchByName(name);
    }
    public ProductRepository getProduct(){
        return (ProductRepository) iProductRepossitory;
    }
}
