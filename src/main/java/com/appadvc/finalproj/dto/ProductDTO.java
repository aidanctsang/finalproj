package com.appadvc.finalproj.dto;

import com.appadvc.finalproj.model.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long productID;

    @NotBlank(message = "Product Name is required")
    private String productName;

    @PositiveOrZero(message = "Price must not be a negative number")
    private float price;

    @PositiveOrZero(message = "Quantity must not be a negative number")
    private String quantity;

    @NotBlank(message = "Description is required")
    private String description;

    private MultipartFile image;

    private String imageLoc;

    public ProductDTO(Products product) {
        this.productID = product.getProductID();
        this.productName = product.getProductName();
        this.price = product.getPrice();
        this.quantity = product.getQty();
        this.description = product.getDescription();
        this.imageLoc = product.getImageLocation();
    }

}
