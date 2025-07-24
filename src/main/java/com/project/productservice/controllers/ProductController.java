package com.project.productservice.controllers;


import com.project.productservice.models.Product;
import com.project.productservice.services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private IProductService productService;

    public ProductController(@Qualifier("productService") IProductService productService) {
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
    public void deleteSingleProduct(@PathVariable("id") Long id)
    {
           productService.deleteProduct(id);
     }
}
