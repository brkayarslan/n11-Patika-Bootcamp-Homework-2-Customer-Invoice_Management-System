package com.berkayarslan.CustomerInvoiceManagementSystem.model;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MERCHANT")
public class Merchant extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Merchant")
    @SequenceGenerator(name = "Merchant", sequenceName = "MERCHANT_ID_SEQ", allocationSize = 1)
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
    private String phoneNumber;

    @Column
    private String eMail;

    @Column
    private Long registrationNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "SECTOR",length = 30)
    private Sector sector;

    @Column
    private LocalDate dateOfRegistration;

}
