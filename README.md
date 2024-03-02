# CUSTOMER INVOICE MANAGEMENT SYSTEM

## Overview
The Customer Invoice Management System is a comprehensive Spring Boot application designed to manage the invoicing process for businesses efficiently. It streamlines the handling of customer information, product catalog, merchant details, and invoice generation, offering a robust backend system for businesses looking to digitize their financial transactions.

## Features:

- Customer Management: Allows for the addition, update, and retrieval of customer information, including details like name, address, tax number, and contact information.
- Product Catalog: A comprehensive system to manage product listings, including descriptions, unit prices, and tax rates, facilitating easy invoice generation.
- Invoice Processing: Enables the creation of detailed invoices, associating them with specific customers and products, including the calculation of total amounts with applicable taxes.
- Merchant Management: Merchants can manage their information, including tax details and contact information, enhancing the system's utility for multiple business entities.
- Data Integrity and Security: Implements robust data validation and error handling to ensure data integrity and security.
- Reporting and Analytics: Provides functionality to generate reports and analytics, such as average invoice amounts, invoices over a certain price, and merchant-specific transactions.

## Technology Stack
This project is built with the following technologies:

- Spring Boot: For creating the backend application. Version: 3.2.3
- H2 Database: An in-memory database for storing the data
- JPA & Hibernate: For ORM and database interaction
- Spring Data JPA: To simplify data access layers
- Lombok: To reduce boilerplate code for model/data objects

## Getting Started
Prerequisites
Before you begin, ensure you have the following installed:

- Java JDK 21 or later
- Maven 4.0.0 or later


## Some Sample Features

- List All Merchants
  ![Output](./outputImg/all-merchants.png)


- Create a new customer

  ![Output](./outputImg/record-customer.png)

- List customers with the letter 'C' in them

  ![Output](./outputImg/merchant-starting-with-c.png)

- List the total amount of invoices of customers who registered in June

  ![Output](./outputImg/monthly-total-of-bills.png)

- List all invoices in the system
  ![Output](./outputImg/all-invoices.png)

- Listing invoices over $1500 in the system

  ![Output](./outputImg/Invoices-over-1500.png)

- Calculating the average of invoices over $1500 in the system

  ![Output](./outputImg/avarage-over-1500.png)

- List customers with invoices under $500 in the system

  ![Output](./outputImg/under-500-customers.png)

- List the industry in which companies whose average invoices for June were below $750

  ![Output](./outputImg/sectors-below-750.png)
