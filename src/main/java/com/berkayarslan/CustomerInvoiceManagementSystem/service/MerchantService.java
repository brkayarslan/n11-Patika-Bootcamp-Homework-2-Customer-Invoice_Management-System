package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseService;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.Merchant;
import com.berkayarslan.CustomerInvoiceManagementSystem.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MerchantService extends BaseService<Merchant,MerchantRepository> {
    protected MerchantService(MerchantRepository repository) {
        super(repository);
    }

    public void printAllMerchants() {
        List<Merchant> merchants = findAll();
        if (merchants.isEmpty()) {
            System.out.println("No merchants found.");
            return;
        }

        System.out.println("\n ALL MERCHANTS \n");

        System.out.printf("%-10s %-30s %-30s %-20s %-30s %-20s %-30s %-20s %s%n",
                "ID", "Name", "Address", "Phone Number", "Email", "Tax Number",
                "Tax Administration", "Registration Number", "Date Of Registration");

        merchants.stream().forEach(merchant ->
                System.out.printf("%-10d %-30s %-30s %-20s %-30s %-20d %-30s %-20d %s%n",
                        merchant.getId(),
                        merchant.getName(),
                        merchant.getAddress(),
                        merchant.getPhoneNumber(),
                        merchant.getEMail(),
                        merchant.getTaxNumber(),
                        merchant.getTaxAdmininstration(),
                        merchant.getRegistrationNumber(),
                        merchant.getDateOfRegistration().toString()));
    }
    public List<Merchant> findByNameContainingIgnoreCase(String name){
        return getRepository().findByNameContainingIgnoreCase(name);
    }
    public void printMerchantsWithNameContaining(String name) {
        List<Merchant> merchantsWithC = findByNameContainingIgnoreCase(name);
        if (merchantsWithC.isEmpty()) {
            System.out.println("No merchants found with " + name + " in the name.");
        } else {
            System.out.printf("%-10s %-30s %-30s %-20s %-30s %-20s %-30s %-20s %s%n",
                    "ID", "Name", "Address", "Phone Number", "Email", "Tax Number",
                    "Tax Administration", "Registration Number", "Date Of Registration");

            merchantsWithC.stream().forEach(merchant ->
                    System.out.printf("%-10d %-30s %-30s %-20s %-30s %-20d %-30s %-20d %s%n",
                            merchant.getId(),
                            merchant.getName(),
                            merchant.getAddress(),
                            merchant.getPhoneNumber(),
                            merchant.getEMail(),
                            merchant.getTaxNumber(),
                            merchant.getTaxAdmininstration(),
                            merchant.getRegistrationNumber(),
                            merchant.getDateOfRegistration().toString()));
        }
    }
    public List<Merchant> findByRegistrationMonthAndYear(int month, int year){
        return getRepository().findByRegistrationMonthAndYear(month,year);
    }
    public void printMerchantsSector(List<Merchant> merchants){
        Set<String> sectors = merchants.stream()
                .map(merchant -> merchant.getSector().toString())
                .collect(Collectors.toSet());

        sectors.forEach(System.out::println);
    }

}
