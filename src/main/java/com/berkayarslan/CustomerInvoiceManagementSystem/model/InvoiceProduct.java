package com.berkayarslan.CustomerInvoiceManagementSystem.model;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@Data
@Entity
@Table(name = "INVOICE_PRODUCT")
public class InvoiceProduct extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "InvoiceProduct")
    @SequenceGenerator(name = "InvoiceProduct", sequenceName = "INVOICE_PRODUCT_ID_SEQ", allocationSize = 1)
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer quantity; // Ürün miktarı


    public InvoiceProduct(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
