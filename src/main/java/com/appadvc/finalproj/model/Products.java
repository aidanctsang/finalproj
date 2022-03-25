package com.appadvc.finalproj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private String qty;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "categories_categoryID")
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "orders_orderID")
    private Orders orders;
}
