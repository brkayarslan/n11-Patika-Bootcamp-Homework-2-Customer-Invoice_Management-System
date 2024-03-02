package com.berkayarslan.CustomerInvoiceManagementSystem.service;

import com.berkayarslan.CustomerInvoiceManagementSystem.general.BaseService;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.Customer;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.Invoice;
import com.berkayarslan.CustomerInvoiceManagementSystem.model.Merchant;
import com.berkayarslan.CustomerInvoiceManagementSystem.repository.InvoiceProductRepository;
import com.berkayarslan.CustomerInvoiceManagementSystem.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class InvoiceService extends BaseService<Invoice,InvoiceRepository> {

    private final MerchantService merchantService;
    private final InvoiceProductRepository invoiceProductRepository;
    protected InvoiceService(InvoiceRepository repository, MerchantService merchantService, InvoiceProductRepository invoiceProductRepository) {
        super(repository);
        this.merchantService = merchantService;
        this.invoiceProductRepository = invoiceProductRepository;
    }


    public void saveInvoice(Invoice invoice){
            invoice.setTotalAmount(getTotalAmount(invoice));
            getRepository().save(invoice);
        }

    public Double getTotalAmount(Invoice invoice){
        double totalAmount = invoice.getInvoiceProducts().stream()
                                                         .mapToDouble(invoiceProduct -> invoiceProduct.getQuantity() * invoiceProduct.getProduct().getUnitPrice() * (1 + invoiceProduct.getProduct().getTaxRate()))
                                                         .sum();
        invoice.setTotalAmount(totalAmount);
        return totalAmount;
    }

    public Double getTotalInvoiceAmountOfRegisteredMerchantListByMonth(int month, int year){
        List<Merchant> merchantList = merchantService.findByRegistrationMonthAndYear(month, year);
        List<Long> merchantIds = merchantList.stream()
                                             .map(Merchant::getId)
                                             .toList();

        List<Invoice> invoiceList = getRepository().findByMerchantIds(merchantIds);

        return invoiceList.stream()
                          .mapToDouble(Invoice::getTotalAmount)
                          .sum();

    }

    public List<Invoice> findAllInvoices(){
        return getRepository().findAll();
    }

    public void printAllInvoices(){

        List<Invoice> invoiceList = findAllInvoices();

        if(invoiceList.isEmpty()){
            System.out.println("No invoices fond");
        }
        else {
            invoiceList.forEach(invoice -> {
                System.out.printf("%-10s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %n", "ID", "Merchant Name","Merchant Address", "Merchant Tax Number","Merchant Tax Administration","Merchant Phone Number","Merchant E-mail",
                        "Customer Name","Customer Address","Customer Tax Number","Customer Tax Administration","Customer E-Mail",
                        "Invoice Date","Bill Number","Order Number", "Current Number","Waybill Number");
                System.out.printf("%-10d %-30s %-30s %-30d %-30s %-30s %-30s %-30s %-30s %-30d %-30s %-30s %-30s %-30d %-30d %-30d %-30d %n",
                        invoice.getId(),
                        invoice.getMerchant().getName(),
                        invoice.getMerchant().getAddress(),
                        invoice.getMerchant().getTaxNumber(),
                        invoice.getMerchant().getTaxAdmininstration(),
                        invoice.getMerchant().getPhoneNumber(),
                        invoice.getMerchant().getEMail(),
                        invoice.getCustomer().getName(),
                        invoice.getCustomer().getAddress(),
                        invoice.getCustomer().getTaxNumber(),
                        invoice.getCustomer().getTaxAdmininstration(),
                        invoice.getCustomer().getEMail(),
                        invoice.getInvoiceDate().toString(),
                        invoice.getBillNumber(),
                        invoice.getOrderNumber(),
                        invoice.getCurrentNumber(),
                        invoice.getWaybillNumber()
                        );

                // Ürün bilgilerini yazdır
                System.out.println("Products:");
                System.out.printf("%-10s %-30s %-30s %-30s %n", "Piece", "Name", "Tax Rate", "Unit Price");
                invoice.getInvoiceProducts().forEach(product -> {
                    System.out.printf("%-10d %-30s %-30.2f %-30.2f %n",
                            product.getQuantity(),
                            product.getProduct().getName(),
                            product.getProduct().getTaxRate(),
                            product.getProduct().getUnitPrice());
                });
                System.out.println("Total amount : " +String.format("%,.2f",invoice.getTotalAmount()) +"$\n\n");;
            });
        }
    }

    public List<Invoice> getInvoicesOverCertainPrice(Double price){
        return getRepository().findByTotalAmountAfter(price);
    }

    public Double getAverageOfInvoicesOverACertainPrice(Double price){
        List<Invoice> invoices = getInvoicesOverCertainPrice(price);

        double total = invoices.stream()
                               .mapToDouble(Invoice::getTotalAmount)
                               .sum();

        double avarage = 0.0;

        if(!invoices.isEmpty()){
            avarage = total / invoices.size();
        }

        return avarage;

    }
    public void printInvoicesOverCertainPrice(Double price){

        List<Invoice> invoiceList = getInvoicesOverCertainPrice(price);

        if(invoiceList.isEmpty()){
            System.out.println("No invoices fond");
        }else{
            invoiceList.forEach(invoice -> {
                System.out.printf("%-10s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %n", "ID", "Merchant Name","Merchant Address", "Merchant Tax Number","Merchant Tax Administration","Merchant Phone Number","Merchant E-mail",
                        "Customer Name","Customer Address","Customer Tax Number","Customer Tax Administration","Customer E-Mail",
                        "Invoice Date","Bill Number","Order Number", "Current Number","Waybill Number");
                System.out.printf("%-10d %-30s %-30s %-30d %-30s %-30s %-30s %-30s %-30s %-30d %-30s %-30s %-30s %-30d %-30d %-30d %-30d %n",
                        invoice.getId(),
                        invoice.getMerchant().getName(),
                        invoice.getMerchant().getAddress(),
                        invoice.getMerchant().getTaxNumber(),
                        invoice.getMerchant().getTaxAdmininstration(),
                        invoice.getMerchant().getPhoneNumber(),
                        invoice.getMerchant().getEMail(),
                        invoice.getCustomer().getName(),
                        invoice.getCustomer().getAddress(),
                        invoice.getCustomer().getTaxNumber(),
                        invoice.getCustomer().getTaxAdmininstration(),
                        invoice.getCustomer().getEMail(),
                        invoice.getInvoiceDate().toString(),
                        invoice.getBillNumber(),
                        invoice.getOrderNumber(),
                        invoice.getCurrentNumber(),
                        invoice.getWaybillNumber()
                );

                // Ürün bilgilerini yazdır
                System.out.println("Products:");
                System.out.printf("%-10s %-30s %-30s %-30s %n", "Piece", "Name", "Tax Rate", "Unit Price");
                invoice.getInvoiceProducts().forEach(product -> {
                    System.out.printf("%-10d %-30s %-30.2f %-30.2f %n",
                            product.getQuantity(),
                            product.getProduct().getName(),
                            product.getProduct().getTaxRate(),
                            product.getProduct().getUnitPrice());
                });
                System.out.println("Total amount : " + String.format("%,.2f",invoice.getTotalAmount())+"$\n\n");;
            });
        }

    }

    public List<Invoice> getInvoicesUnderACertainAmount(Double price){
        return getRepository().findByTotalAmountBefore(price);
    }

    public void printCustomersWithInvoicesBelowACertainAmount(Double price){
        List<Invoice> invoices = getInvoicesUnderACertainAmount(price);
        HashSet<Customer> customers = new HashSet<>();
        if(invoices.isEmpty()){
            System.out.println("No invoices fond");
        }else {
            invoices.forEach(invoice -> {
                customers.add(invoice.getCustomer());
            });

            System.out.printf("%-10s %-30s %-30s %-30s %-30s %-30s %n","Id","Name","Address","Tax Number", "Tax Administration","E-Mail");
            customers.forEach(customer -> {
                System.out.printf("%-10d %-30s %-30s %-30d %-30s %-30s %n",
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getTaxNumber(),
                        customer.getTaxAdmininstration(),
                        customer.getEMail());
            });
        }

    }

    public List<Invoice> getInvoicesByMonthAndYear(int month,int year){
        return getRepository().findByMonthAndYear(month, year);
    }

    public List<Invoice> getInvoicesByMerchantAndMonth(Long merchantId, int month, int year){
        return getRepository().findInvoicesByMerchantAndMonth(merchantId,month,year);
    }

    public Double getAvarageOfInvoicesByMerchantAndMonth(Long merchantId, int month, int year){
        List<Invoice> invoices = getInvoicesByMerchantAndMonth(merchantId,month,year);
        double total = invoices.stream()
                .mapToDouble(Invoice::getTotalAmount)
                .sum();

        double avarage = 0.0;

        if(!invoices.isEmpty()){
            avarage = total / invoices.size();
        }

        return avarage;
    }

    public List<Merchant> findMerchantsWithAverageInvoiceAmountBelowInMonth(int month, int year,double price){
        List<Merchant> merchantList = merchantService.findAll();
        List<Merchant> returnMerchant = new ArrayList<>();
        for(Merchant merchant : merchantList){
            double avarage = getAvarageOfInvoicesByMerchantAndMonth(merchant.getId(),month,year);
            if(avarage < price){
                returnMerchant.add(merchant);
            }
        }
        return returnMerchant;
    }



}
