package com.berkayarslan.CustomerInvoiceManagementSystem.repository;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.Customer;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Long> {
}
