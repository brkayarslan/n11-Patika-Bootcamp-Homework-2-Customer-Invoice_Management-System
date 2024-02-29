package com.berkayarslan.CustomerInvoiceManagementSystem.repository;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Long> {
}
