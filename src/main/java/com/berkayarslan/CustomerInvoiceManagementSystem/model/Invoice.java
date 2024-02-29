package com.berkayarslan.CustomerInvoiceManagementSystem.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "INVOICE")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "merchant_id")
    @ManyToOne
    private Merchant merchant;

    @JoinColumn(name = "customer_id")
    @ManyToOne
    private Customer customer;

    @Column
    private Long billNumber;

    @Column
    private LocalDateTime invoiceDate;

    @Column
    private Long orderNumber;

    @Column
    private Long currentNumber;

    @Column
    private Long waybillNumber;

    @JoinTable(
            name = "invoice_product",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @ManyToMany
    private List<Product> product;

}
