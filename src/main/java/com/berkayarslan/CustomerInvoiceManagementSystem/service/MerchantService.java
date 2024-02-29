package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.repository.MerchantRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }


}
