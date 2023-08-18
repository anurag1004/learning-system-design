package com.srp.main;

/*
* SRP or Single Responsibility Principle
*  States: The class should only have a single reason to change or should be responsible for only one thing
 */

import com.srp.main.models.*;

public class Main {
    public static void main(String[] args) {
        Book myBook = new Book("Harry potter","XYZ", 23.5F);
        Invoice invoice1 = new Invoice(myBook, 10);
        InvoiceSRP invoice2 = new InvoiceSRP(myBook, 10, new InvoiceRepository(), new InvoicePrinter());
    }
}
