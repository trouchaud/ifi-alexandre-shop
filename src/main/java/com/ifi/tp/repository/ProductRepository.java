package com.ifi.tp.repository;

import com.ifi.tp.bo.Product;

import java.util.List;

public interface ProductRepository {
    Product findById(int id);
    Product findByName(String name);
    List<Product> findAll();
}
