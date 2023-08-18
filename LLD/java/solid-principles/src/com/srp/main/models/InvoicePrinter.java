package com.srp.main.models;

public class InvoicePrinter {
    public void print(String name, int quantity, float total){
        // prints the invoice in some format
        System.out.printf("BookName:%s, Quantity:%d, Price:%s$", name, quantity, String.valueOf(total));
    }
}
