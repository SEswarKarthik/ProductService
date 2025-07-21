package com.project.productservice.controllers;


import com.project.productservice.models.Product;
import com.project.productservice.services.FakeStoreProductService;
import com.project.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id)
    {
        return productService.getSingleProduct(id);
    }
    @PostMapping()
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }
    @DeleteMapping("/{id}")
    public boolean deleteSingleProduct(@PathVariable("id") Long id)
    {
          return productService.deleteProduct(id);
     }
}
