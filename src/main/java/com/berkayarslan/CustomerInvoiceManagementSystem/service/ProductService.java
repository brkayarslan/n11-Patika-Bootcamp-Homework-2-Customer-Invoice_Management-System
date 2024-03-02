package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseService;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.Product;
import com.berkayarslan.CustomerInvoiceManagementSystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseService<Product,ProductRepository> {


    protected ProductService(ProductRepository repository) {
        super(repository);
    }
}
