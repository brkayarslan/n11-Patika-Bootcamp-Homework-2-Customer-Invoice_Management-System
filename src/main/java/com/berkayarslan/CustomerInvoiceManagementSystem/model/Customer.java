package com.berkayarslan.CustomerInvoiceManagementSystem.model;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CUSTOMER")
public class Customer extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Customer")
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Long taxNumber;

    @Column
    private String taxAdmininstration;

    @Column
    private String eMail;




}
