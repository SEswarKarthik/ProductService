package com.project.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends BaseModel{
    private  String title;
    private  Double price;
    private  String description;
    private  Category category;
    private  String imageURL;


}
