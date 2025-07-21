package com.project.productservice.services;

import com.project.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getSingleProduct(Long id);

    Product createProduct(Product product);

    boolean deleteProduct(Long id);


}
