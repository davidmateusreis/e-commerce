package com.david.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.backend.entity.Product;
import com.david.backend.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping({ "/addNewProduct" })
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }
}
