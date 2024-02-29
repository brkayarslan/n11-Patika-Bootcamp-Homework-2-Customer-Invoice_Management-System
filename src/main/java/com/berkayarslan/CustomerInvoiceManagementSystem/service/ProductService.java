package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
