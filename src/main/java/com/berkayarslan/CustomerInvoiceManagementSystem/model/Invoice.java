package com.berkayarslan.CustomerInvoiceManagementSystem.model;


import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "INVOICE")
public class Invoice extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Invoice")
    @SequenceGenerator(name = "Invoice", sequenceName = "INVOICE_ID_SEQ", allocationSize = 1)
    @Id
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


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceProduct> invoiceProducts;

    @Column
    private Double totalAmount;


    public Invoice(Merchant merchant, Customer customer, Long billNumber, LocalDateTime invoiceDate, Long orderNumber, Long currentNumber, Long waybillNumber, List<InvoiceProduct> invoiceProducts) {
        this.merchant = merchant;
        this.customer = customer;
        this.billNumber = billNumber;
        this.invoiceDate = invoiceDate;
        this.orderNumber = orderNumber;
        this.currentNumber = currentNumber;
        this.waybillNumber = waybillNumber;
        this.invoiceProducts = invoiceProducts;
    }
}
