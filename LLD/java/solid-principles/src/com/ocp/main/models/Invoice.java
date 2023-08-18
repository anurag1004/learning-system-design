package com.ocp.main.models;

import com.ocp.main.models.Book;
import com.ocp.main.models.InvoicePrinter;
import com.ocp.main.models.InvoiceRepository;

public class Invoice{
    Book book;
    int quantity;
    float total;


    public Invoice(Book book, int quantity){
        this.book = book;
        this.quantity = quantity;
        this.getTotal();
    }
    public float getTotal(){
        this.total = quantity*book.bookPrice;
        return total;
    }
    public void printInvoice(InvoicePrinter invoicePrinter){
        invoicePrinter.print(this);
    }

    public void save(InvoiceRepository invoiceRepository){
        invoiceRepository.save(this);
    }

}
