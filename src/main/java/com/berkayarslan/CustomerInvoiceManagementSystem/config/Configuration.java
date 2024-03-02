package com.berkayarslan.CustomerInvoiceManagementSystem.config;

import com.berkayarslan.CustomerInvoiceManagementSystem.model.*;
import com.berkayarslan.CustomerInvoiceManagementSystem.service.*;
import jakarta.annotation.PostConstruct;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private final MerchantService merchantService;

    private final InvoiceService invoiceService;

    private final CustomerService customerService;

    private final InvoiceProductService invoiceProductService;

    private final ProductService productService;

    public Configuration(MerchantService merchantService, InvoiceService invoiceService, CustomerService customerService, InvoiceProductService invoiceProductService, ProductService productService) {
        this.merchantService = merchantService;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.invoiceProductService = invoiceProductService;
        this.productService = productService;
    }


    @PostConstruct
    public void configuration(){
        List<Merchant> merchants = createMerchants();
        for (Merchant merchant : merchants){
            merchantService.save(merchant);
        }

        List<Customer> customers = createCustomers();
        for(Customer customer : customers){
            customerService.save(customer);
        }

        List<Product> products = createProducts();
        List<Product> savedProductsList = new ArrayList<>();
        for(Product product : products){
            savedProductsList.add(productService.save(product));
        }


        List<InvoiceProduct> invoiceProducts = createInvoiceProducts(savedProductsList);
        for(InvoiceProduct invoiceProduct : invoiceProducts){
            invoiceProductService.save(invoiceProduct);
        }

        List<Merchant> savedMerchants = merchantService.findAll();
        List<Customer> savedCustomers = customerService.findAll();
        List<Product> savedProducts = productService.findAll();

        for (Merchant merchant : savedMerchants) {
            for (Customer customer : savedCustomers) {

                Random random = new Random();

                // Generate a random date in 2023
                int dayOfYear = random.nextInt(LocalDate.ofYearDay(2023, 1).lengthOfYear()) + 1;
                LocalDate date = LocalDate.ofYearDay(2023, dayOfYear);
                LocalTime time = LocalTime.now();

                // Combine date and time
                LocalDateTime randomDateTime = LocalDateTime.of(date, time);

                // Rastgele bir ürün listesi oluşturarak InvoiceProduct'lar oluştur
                List<InvoiceProduct> newInvoiceProducts = randomInvoiceProducts(savedProducts);

                // Fatura detaylarını belirle
                Invoice invoice = new Invoice();
                invoice.setMerchant(merchant);
                invoice.setCustomer(customer);
                invoice.setBillNumber((long) (((Math.random()+ 1)* 1000000)));
                invoice.setWaybillNumber((long) (((Math.random()+ 1)* 2000000)));
                invoice.setInvoiceDate(randomDateTime);
                invoice.setOrderNumber((long) (((Math.random()+ 1)* 5000000)));
                invoice.setInvoiceProducts(newInvoiceProducts);


                // Faturayı kaydet
                invoiceService.saveInvoice(invoice);
            }
        }

    }


    public List<Merchant> createMerchants() {
        List<Merchant> merchants = new ArrayList<>();

        merchants.add(createMerchant("Zoombox", "29 Tony Plaza", 48305931L, "Mingelchaur", "227-127-0537", "ningham0@msn.com", 65027240L, Sector.Automobile,LocalDate.of(2023, 6, 20)));
        merchants.add(createMerchant("Vinder", "67915 Stephen Junction", 19676474L, "Cumedak", "354-337-1294", "fkleinstein1@ustream.tv", 80810409L, Sector.Technology,LocalDate.of(2022, 5, 3)));
        merchants.add(createMerchant("Realcube", "5708 Garrison Junction", 323456789L, "Atalhada", "846-247-7680", "dgarmon2@dyndns.org", 96620054L, Sector.Retail,LocalDate.of(2021, 6, 14)));
        merchants.add(createMerchant("Zoomcast", "99 Utah Crossing", 95872547L, "Yuqian", "776-305-8059", "kblackwell3@salon.com", 19981409L, Sector.Food,LocalDate.of(2023, 8, 19)));
        merchants.add(createMerchant("Jaxspan", "9637 Monument Drive", 27885390L, "Galán", "813-927-4134", "cklasing4@squidoo.com", 55158656L, Sector.Healthcare,LocalDate.of(2022, 4, 24)));
        merchants.add(createMerchant("Gigaclub", "769 Colorado Street", 26860639L, "Nelspruit", "215-785-8354", "mstut5@utexas.edu", 30131046L, Sector.Education,LocalDate.of(2023, 6, 17)));
        merchants.add(createMerchant("Yadel", "52200 Autumn Leaf Hill", 723456789L, "Massaguet", "857-598-7919", "jwestrip6@miibeian.gov.cn", 58486081L, Sector.Energy,LocalDate.of(2021, 1, 10)));
        merchants.add(createMerchant("Twitterbridge", "32 Rieder Alley", 92703637L, "Independencia", "283-935-4595", "contact8@examplemerchant.com", 85029000L, Sector.Manufacturing,LocalDate.of(2022, 3, 8)));
        merchants.add(createMerchant("Flipstorm", "8523 Larry Plaza", 923456789L, "Olovyannaya", "103-105-3059", "aferrettini7@hibu.com", 66650280L, Sector.Construction,LocalDate.of(2023, 2, 27)));
        merchants.add(createMerchant("Tagcat", "8833 Heffernan Plaza", 1023456789L, "Zhongshi", "684-206-7417", "hlitton8@marketwatch.com", 14150222L, Sector.Finance,LocalDate.of(2023, 6, 4)));

        return merchants;
    }

    // Merchant nesnesi oluşturmak için yardımcı method
    public Merchant createMerchant(String name, String address, long taxNumber, String taxAdministration, String phoneNumber, String email, long registrationNumber, Sector sector,LocalDate localDate) {
        Merchant merchant = new Merchant();
        merchant.setName(name);
        merchant.setAddress(address);
        merchant.setTaxNumber(taxNumber);
        merchant.setTaxAdmininstration(taxAdministration);
        merchant.setPhoneNumber(phoneNumber);
        merchant.setEMail(email);
        merchant.setRegistrationNumber(registrationNumber);
        merchant.setSector(sector);
        merchant.setDateOfRegistration(localDate);
        return merchant;
    }

    public List<Customer> createCustomers(){
        List<Customer> customers = new ArrayList<>();

        customers.add(createCustomer("Tymon Callinan","08 Mandrake Hill",6699592651L,"Ciputih","tcallinan0@comsenz.com"));
        customers.add(createCustomer("Hilarius Hallin","307 Lotheville Center",4603721946L,"Huainan","hhallin1@dailymotion.com"));
        customers.add(createCustomer("Kendra Mulholland","60062 Forster Road",5364358789L,"Herzliyya","kmulholland2@cocolog-nifty.com"));
        customers.add(createCustomer("Lucina Hevey","22103 Buell Terrace",4241654377L,"Jiangqiao","lhevey3@dailymotion.com"));
        customers.add(createCustomer("Abdel McMurdo","9 Melby Trail",1786336733L,"Honda","amcmurdo4@ibm.com"));

        return customers;

    }

    public Customer createCustomer(String name, String address, Long taxNumber, String taxAdmininstration,String eMail){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setTaxNumber(taxNumber);
        customer.setTaxAdmininstration(taxAdmininstration);
        customer.setEMail(eMail);

        return customer;

    }

    public List<Product> createProducts(){
        List<Product> products = new ArrayList<>();

        products.add(new Product("Lamb Rack - Ontario",0.13,24.33));
        products.add(new Product("Baking Soda",0.17,28.32));
        products.add(new Product("Wine - Carmenere Casillero Del",0.03,18.2));
        products.add(new Product("Eggroll",0.11,53.15));
        products.add(new Product("Ice Cream Bar - Oreo Sandwich",0.91,17.41));
        products.add(new Product("Chivas Regal - 12 Year Old",0.03,21.56));
        products.add(new Product("Beer - Fruli",0.17,18.44));
        products.add(new Product("Beef - Ground, Extra Lean",0.2,20.95));
        products.add(new Product("Thyme - Lemon, Fresh",0.09,24.32));
        products.add(new Product("Cheese - Le Cheve Noir",0.28,14.55));
        products.add(new Product("Tea Leaves - Oolong",0.03,25.9));
        products.add(new Product("Beans - Butter Lrg Lima",0.25,15.34));

        return products;
    }

    public List<InvoiceProduct> createInvoiceProducts(List<Product> products){
        List<InvoiceProduct> invoiceProducts = new ArrayList<>();

        for(Product product : products){
            invoiceProducts.add(new InvoiceProduct(product,(int)(Math.random() * 10) + 1));
        }

        return invoiceProducts;
    }

    public List<InvoiceProduct> randomInvoiceProducts(List<Product> savedProducts) {
        List<InvoiceProduct> invoiceProducts = new ArrayList<>();
        Random random = new Random();
        int numberOfProductsToAdd = random.nextInt(savedProducts.size()) + 1;

        // Ürünler listesinden rastgele 4 farklı ürün seç
        Set<Integer> productIndices = new HashSet<>();
        while (productIndices.size() < numberOfProductsToAdd) {
            int randomIndex = random.nextInt(savedProducts.size());
            productIndices.add(randomIndex);
        }

        // Seçilen ürünler için InvoiceProduct nesneleri oluştur
        for (Integer index : productIndices) {
            Product selectedProduct = savedProducts.get(index);
            int quantity = random.nextInt(10) + 1; // Rastgele miktar (1 ile 10 arası)
            InvoiceProduct invoiceProduct = new InvoiceProduct(selectedProduct, quantity);
            invoiceProducts.add(invoiceProduct);
        }

        return invoiceProducts;
    }


}
