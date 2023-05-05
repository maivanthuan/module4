package main.shopping.service;

import main.shopping.entity.Product;
import main.shopping.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void add(Product product) {
     iProductRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }
}
