package com.berkayarslan.CustomerInvoiceManagementSystem.model;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double taxRate;

    @Column
    private Double unitPrice;


    public Product(String name, Double taxRate, Double unitPrice) {
        this.name = name;
        this.taxRate = taxRate;
        this.unitPrice = unitPrice;
    }
}
