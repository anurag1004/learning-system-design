package com.ocp.main.models;

public class InvoiceFileRepository implements InvoiceRepository{

    @Override
    public void save(Invoice invoice) {
        System.out.println("Saved to file!");
    }
}
