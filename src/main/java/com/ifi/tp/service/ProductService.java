package com.ifi.tp.service;

import com.ifi.tp.bo.Product;

import java.util.List;

public interface ProductService {
    Product getProduct(int id);
    List<Product> getAllProducts();
}
