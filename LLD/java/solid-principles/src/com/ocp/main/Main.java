package com.ocp.main;

import com.ocp.main.models.*;

/*
* Open-Closed Principle
* States: Open for extension and closed for modification
* In earlier impl (invoice class), if we req to save invoice to db then we would create another method
* say - saveToDb() and it'll work. But the catch here is, OCP says that a class should not be modified.
* Imagine creating method of many other dbs and modifying the InvoiceRepository class, and if many developers are
* modifying the same class, then it could lead to conflicts and difficulties in managing the codebase.
* Moreover, every time a new database support is required, all developers working on different databases would need
* to make changes to the same class, leading to a violation of the Open-Closed Principle.
* So how can you add the method without modifying the class itself? Simple - use an interface or an abstract method
* */
public class Main {
    public static void main(String[] args) {
        Book myBook = new Book("Harry potter","XYZ", 23.5F);
        Invoice invoice = new Invoice(myBook, 10);
        // suppose i want to save to file
        invoice.save(new InvoiceFileRepository());
        // suppose i want to save to db
        invoice.save(new InvoiceDbRepository());

        // print to screen
        invoice.printInvoice(new InvoiceScreenPrinter());
        System.out.println();
        // print to paper
        invoice.printInvoice(new InvoiceXeroxPrinter());
    }
}
