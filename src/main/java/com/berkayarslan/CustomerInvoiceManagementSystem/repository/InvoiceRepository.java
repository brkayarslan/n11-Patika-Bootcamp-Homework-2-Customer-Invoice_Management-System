package com.berkayarslan.CustomerInvoiceManagementSystem.repository;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}