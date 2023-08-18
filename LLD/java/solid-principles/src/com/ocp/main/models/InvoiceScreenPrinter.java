package com.ocp.main.models;

public class InvoiceScreenPrinter implements  InvoicePrinter {
    public void print(Invoice invoice){
        // prints the invoice in some format
        System.out.printf("BookName:%s, Quantity:%d, Price:%s$", invoice.book.name, invoice.quantity, String.valueOf(invoice.total));
    }
}
