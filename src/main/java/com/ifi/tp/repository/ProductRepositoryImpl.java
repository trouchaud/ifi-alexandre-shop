package com.ifi.tp.repository;

import java.io.*;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.ifi.tp.bo.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private ObjectMapper objectMapper = new ObjectMapper();

    private List<Product> products;

    public ProductRepositoryImpl() {
        try {
            var shopStream = new ClassPathResource("/shop.json").getInputStream();
            this.products = objectMapper.readValue(shopStream, new TypeReference<List<Product>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        return products.parallelStream()
                .filter((product -> product.getId() == id))
                .findFirst().orElse(null);
    }

    @Override
    public Product findByName(String name) {
        return products.parallelStream()
                .filter((product -> name.equals(product.getName())))
                .findFirst().orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return this.products;
    }

}
