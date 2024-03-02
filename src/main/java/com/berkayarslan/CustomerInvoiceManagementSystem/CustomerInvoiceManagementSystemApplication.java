package com.berkayarslan.CustomerInvoiceManagementSystem;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.*;
import com.berkayarslan.CustomerInvoiceManagementSystem.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class CustomerInvoiceManagementSystemApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CustomerInvoiceManagementSystemApplication.class, args);

        MerchantService merchantService = context.getBean(MerchantService.class);

        InvoiceService invoiceService = context.getBean(InvoiceService.class);

        CustomerService customerService = context.getBean(CustomerService.class);

        ProductService productService = context.getBean(ProductService.class);


        //MERCHANT RECORD EXAMPLE
        Merchant merchant = new Merchant();
        merchant.setName("Example Merchant");
        merchant.setAddress("1234 Main Street, Anytown, AN 12345");
        merchant.setTaxNumber(123456789L);
        merchant.setTaxAdmininstration("Anytown Tax Office");
        merchant.setPhoneNumber("555-1234");
        merchant.setEMail("contact@examplemerchant.com");
        merchant.setRegistrationNumber(987654321L);
        merchant.setSector(Sector.Automobile);
        merchant.setDateOfRegistration(LocalDate.now());

        merchantService.save(merchant);


        //PRINT ALL MERCHANTS
        merchantService.printAllMerchants();

        System.out.println("\n\nMERCHANTS WITH THE LETTER C IN THEIR NAME :");
        //Printing merchants containing the letter C
        merchantService.printMerchantsWithNameContaining("C");


        System.out.println("\n\n Total invoice amount of merchants registered in the 6th month : "+ invoiceService.getTotalInvoiceAmountOfRegisteredMerchantListByMonth(6, 2023) +"$\n");


        Customer customer = new Customer();
        customer.setName("Berkay");
        customer.setAddress("İstanbul/Kadıköy");
        customer.setTaxNumber(1234567L);
        customer.setTaxAdmininstration("Ataşehir");
        customer.setEMail("berkayarslan9@gmail.com");

        customerService.save(customer);


        Product product1 = new Product();
        product1.setName("Orange");
        product1.setTaxRate(0.2);
        product1.setUnitPrice(1.8);

        Product product2 = new Product();
        product2.setName("Apple");
        product2.setTaxRate(0.18);
        product2.setUnitPrice(2.4);

        productService.save(product1);
        productService.save(product2);


        InvoiceProduct invoiceProduct1 = new InvoiceProduct(product1,4);
        InvoiceProduct invoiceProduct2 = new InvoiceProduct(product2,3);

        List<InvoiceProduct> invoiceProducts = new ArrayList<>();
        invoiceProducts.add(invoiceProduct1);
        invoiceProducts.add(invoiceProduct2);



        //INVOICE RECORD EXAMPLE
        Invoice invoice = new Invoice(merchant,customer,258741L, LocalDateTime.now(),9638527L,741852L,951753L,invoiceProducts);
        invoiceService.saveInvoice(invoice);


        System.out.println("ALL INVOICES");
        invoiceService.printAllInvoices();


        System.out.println("\n BILLS OVER $1500 \n");
        invoiceService.printInvoicesOverCertainPrice(1500.0);


        System.out.println("\n Average of bills over $1500 : " +String.format("%,.2f",invoiceService.getAverageOfInvoicesOverACertainPrice(1500.0)) +"$\n");


        System.out.println("\n CUSTOMERS WİTH INVOICES UNDER $500 \n");
        invoiceService.printCustomersWithInvoicesBelowACertainAmount(500.0);


        System.out.println("\n SECTORS OF MERCHANTS UNDER $750");
        merchantService.printMerchantsSector(invoiceService.findMerchantsWithAverageInvoiceAmountBelowInMonth(6,2023,750.0));

	}


}
