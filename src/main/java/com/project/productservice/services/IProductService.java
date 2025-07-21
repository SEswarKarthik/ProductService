package com.project.productservice.services;

import com.project.productservice.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(Long id);

    Product createProduct(Product product);

    boolean deleteProduct(Long id);


}
