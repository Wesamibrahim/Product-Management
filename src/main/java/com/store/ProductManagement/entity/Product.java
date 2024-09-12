package com.store.ProductManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "The name is required")
    private String name;

    @Column(name ="brand")
    @NotEmpty(message = "The brand is required")
    private String brand;

    @Column(name = "category")
    @NotEmpty(message = "The category is required ")
    private String category;

    @Column(name = "price")
    @NotNull(message = " The price is required")
    @Min(0)
    private Double price;

    @Column(name = "description")
    @Size(min = 10 ,message = "The description should be at least 10 characters")
    @Size(max = 2000 , message = " The description cannot exceed 2000 characters ")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "imageFileName")
    private String imageFileName;

    public Product(){

    }

    public Product(String name, String brand, String category, double price, String description, Date date, String imageFileName) {
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.description = description;
        this.date = date;
        this.imageFileName = imageFileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}
