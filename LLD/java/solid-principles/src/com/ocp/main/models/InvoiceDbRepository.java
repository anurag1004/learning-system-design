package com.ocp.main.models;

public class InvoiceDbRepository implements  InvoiceRepository{

    @Override
    public void save(Invoice invoice) {
        // save to db
        System.out.println("Saved to DB (whatever it is.. can be SQL, mongo)");
    }
}
