package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseService;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.Customer;
import com.berkayarslan.CustomerInvoiceManagementSystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<Customer,CustomerRepository> {


    protected CustomerService(CustomerRepository repository) {
        super(repository);
    }
}
