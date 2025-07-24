package com.project.productservice.services;

import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import com.project.productservice.repositories.CategoryRepository;
import com.project.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("productService")
@Primary
public class ProductService implements IProductService{
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        Category category= product.getCategory();
        Optional<Category> optionalCategory=categoryRepository.findByName(category.getName());
        if(optionalCategory.isEmpty()){
            categoryRepository.save(category);
        }
        else{
            category = optionalCategory.get();
        }
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
         productRepository.deleteById(id);
    }
}
