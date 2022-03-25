package com.appadvc.finalproj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderID;

    @OneToMany(mappedBy = "orders")
    private List<Products> products;

    @ManyToOne
    @JoinColumn(name = "users_userID")
    private Users users;

    @Column(updatable = false)
    private LocalDateTime orderDate;

    @OneToOne(mappedBy = "orders",
    cascade = CascadeType.ALL)
    private Transaction transaction;
}
