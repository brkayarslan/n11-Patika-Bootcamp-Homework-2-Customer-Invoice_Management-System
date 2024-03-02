package com.berkayarslan.CustomerInvoiceManagementSystem.repository;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.Invoice;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("SELECT i FROM Invoice i WHERE i.merchant.id = :merchantId")
    List<Invoice> findByMerchantId(@Param("merchantId") Long merchantId);
    @Query("SELECT i FROM Invoice i WHERE i.merchant.id IN :merchantIds")
    List<Invoice> findByMerchantIds(@Param("merchantIds") List<Long> merchantIds);
    List<Invoice> findByTotalAmountAfter(Double price);
    List<Invoice> findByTotalAmountBefore(Double price);
    @Query("SELECT i FROM Invoice i WHERE MONTH(i.invoiceDate) = :month AND YEAR(i.invoiceDate) = :year")
    List<Invoice> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
    @Query("SELECT i FROM Invoice i WHERE i.merchant.id = :merchantId AND FUNCTION('MONTH', i.invoiceDate) = :month AND FUNCTION('YEAR', i.invoiceDate) = :year")
    List<Invoice> findInvoicesByMerchantAndMonth(@Param("merchantId") Long merchantId, @Param("month") int month, @Param("year") int year);

}
