package com.berkayarslan.CustomerInvoiceManagementSystem.repository;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MerchantRepository extends JpaRepository<Merchant,Long> {

    List<Merchant> findByNameContainingIgnoreCase(String name);
    @Query("SELECT m FROM Merchant m WHERE MONTH(m.dateOfRegistration) = :month AND YEAR(m.dateOfRegistration) = :year")
    List<Merchant> findByRegistrationMonthAndYear(@Param("month") int month, @Param("year") int year);

}
