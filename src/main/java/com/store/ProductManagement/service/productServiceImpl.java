package com.store.ProductManagement.service;

import com.store.ProductManagement.dao.ProductRepository;
import com.store.ProductManagement.entity.Product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServiceImpl implements ProductService {


    private ProductRepository productRepository;

    public productServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
     public List<Product> findAll(){
     return productRepository.findAll();
 }

    @Override
    public Product findById(int theId) {

        Optional<Product> result = productRepository.findById(theId);
        Product theProduct = null;
        if (result.isPresent()){
            theProduct=result.get();

        }
      else {
          throw new RuntimeException (" Did not found product id - :" + theId);
        }
        return theProduct;
    }

    @Override
    public Product save(Product theProduct) {
        return productRepository.save(theProduct);
    }

    @Override
    public void deleteById(int theId) {

    }
}
