package com.store.ProductManagement.service;

import com.store.ProductManagement.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(int theId);

    Product save(Product theProduct);

    void deleteById(int theId);
}
