package com.ifi.tp.controller;

import com.ifi.tp.bo.Product;
import com.ifi.tp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    Product getProductFromId(@PathVariable int id){
        return productService.getProduct(id);
    }

    @GetMapping("")
    List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
