package com.appadvc.finalproj.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Data
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionID;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(updatable = false)
    private LocalDateTime paymentDate;

    public Transaction() {

    }
}
