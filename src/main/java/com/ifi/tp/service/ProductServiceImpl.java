package com.ifi.tp.service;

import com.ifi.tp.bo.Product;
import com.ifi.tp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {
        return this.productRepository.findById(id);
    }
}
