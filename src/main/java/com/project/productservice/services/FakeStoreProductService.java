package com.project.productservice.services;

import com.project.productservice.dtos.FakeStoreProductDto;
import com.project.productservice.models.Category;
import com.project.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> getAllProducts=
        restTemplate.getForEntity("https://fakestoreapi.com/products",FakeStoreProductDto[].class);

        FakeStoreProductDto[] fsGetALLResponseObject=getAllProducts.getBody();
        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDto fsGetAll: fsGetALLResponseObject){
            products.add(convertFakeStoreDTOToProduct(fsGetAll));
        }
        return products;
    }

    @Override
    public Product getSingleProduct(Long id) {
        ResponseEntity<FakeStoreProductDto> getSingleProduct =
                restTemplate.getForEntity("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        FakeStoreProductDto fsdto = getSingleProduct.getBody();

        return convertFakeStoreDTOToProduct(fsdto);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        

    }

    public Product convertFakeStoreDTOToProduct(FakeStoreProductDto fsp){
        Product product =new Product();
        product.setId(fsp.getId());
        product.setTitle(fsp.getTitle());
        product.setPrice(fsp.getPrice());
        product.setDescription(fsp.getDescription());
        product.setImageURL(fsp.getImage());

        Category category =new Category();
        category.setDescription(fsp.getCategory());

        product.setCategory(category);

       return product;

    }
}
