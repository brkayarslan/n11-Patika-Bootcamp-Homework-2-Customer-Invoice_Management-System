package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
