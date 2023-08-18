package com.ocp.main.models;

public class InvoiceXeroxPrinter implements  InvoicePrinter{

    @Override
    public void print(Invoice invoice) {
        System.out.println("XEROX DONE!");
    }
}
