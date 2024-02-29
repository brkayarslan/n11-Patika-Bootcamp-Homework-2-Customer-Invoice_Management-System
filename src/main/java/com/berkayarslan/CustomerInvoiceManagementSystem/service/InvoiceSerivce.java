package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceSerivce {

    private final InvoiceRepository invoiceRepository;

    public InvoiceSerivce(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}
