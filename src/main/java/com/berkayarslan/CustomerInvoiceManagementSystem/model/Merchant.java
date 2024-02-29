package com.berkayarslan.CustomerInvoiceManagementSystem.model;

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
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column
    private Sector sector;

    @Column
    private LocalDate dateOfRegistration;

}
