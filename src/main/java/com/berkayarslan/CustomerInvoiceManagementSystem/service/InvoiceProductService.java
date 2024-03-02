package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseService;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.InvoiceProduct;
import com.berkayarslan.CustomerInvoiceManagementSystem.repository.InvoiceProductRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceProductService extends BaseService<InvoiceProduct, InvoiceProductRepository> {
    protected InvoiceProductService(InvoiceProductRepository repository) {
        super(repository);
    }
}
