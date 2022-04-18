package com.appadvc.finalproj.dto;

import com.appadvc.finalproj.model.Categories;
import com.appadvc.finalproj.model.Products;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class ProductDTO {

    private Long productid;

    @NotBlank(message = "Name is required")
    private String productname;

    @PositiveOrZero(message = "Price must not be a negative number")
    private float price;

    @PositiveOrZero(message = "Quantity must not be a negative number")
    private String quantity;

    @NotBlank(message = "Description is required")
    private String description;


    private MultipartFile image;

    private String imageLoc;

    public ProductDTO() {
    }

    public ProductDTO(Products product) {
        this.productid = product.getProductID();
        this.productname = product.getProductName();
        this.price = product.getPrice();
        this.quantity = product.getQty();
        this.quantity = product.getDescription();
        this.imageLoc = product.getImageLocation();
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductId(Long id) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductName(String name) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageLoc() {
        return imageLoc;
    }

    public void setImageLoc(String imageLoc) {
        this.imageLoc = imageLoc;
    }

}
