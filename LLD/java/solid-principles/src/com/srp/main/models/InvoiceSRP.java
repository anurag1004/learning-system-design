package com.srp.main.models;

/**
 * This class now follows SRP, its job is to calc total amount for the books purchased
 */
public class InvoiceSRP{
    Book book;
    int quantity;
    float total;

    InvoicePrinter invoicePrinter;
    InvoiceRepository invoiceRepository;

    public InvoiceSRP(Book book, int quantity, InvoiceRepository invoiceRepository, InvoicePrinter invoicePrinter){
        this.book = book;
        this.quantity = quantity;
        this.invoiceRepository = invoiceRepository;
        this.invoicePrinter = invoicePrinter;
    }
    public float getTotal(){
        this.total = quantity*book.bookPrice;
        return total;
    }
    public void printInvoice(){
        this.invoicePrinter.print(this.book.name, this.quantity, this.total);
    }

    public void saveInvoiceToFile(){
        this.invoiceRepository.saveToFile();
    }

}
