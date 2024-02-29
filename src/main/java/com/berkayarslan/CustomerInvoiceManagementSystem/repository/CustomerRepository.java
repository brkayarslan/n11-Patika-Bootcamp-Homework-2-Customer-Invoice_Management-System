package com.berkayarslan.CustomerInvoiceManagementSystem.repository;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
