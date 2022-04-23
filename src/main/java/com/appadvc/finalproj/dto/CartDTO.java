package com.appadvc.finalproj.dto;

import com.appadvc.finalproj.model.Cart;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
public class CartDTO {
    private Long cartID;

    @NotBlank(message = "Product Name is required")
    private String productName;

    @PositiveOrZero(message = "Price must not be a negative number")
    private float price;

    @PositiveOrZero(message = "Quantity must not be a negative number")
    private String quantity;

    public CartDTO (Cart cart) {
        this.cartID = cart.getCartID();
        this.productName = cart.getProductName();
        this.price = cart.getPrice();
        this.quantity = cart.getQty();
    }
}
