package com.srp.main.models;

import com.srp.main.models.Book;

// Resp of Invoice: Creating an invoice and calculating total price
public class Invoice{
    Book book;
    int quantity;
    float total;


    public Invoice(Book book, int quantity){
        this.book = book;
        this.quantity = quantity;
    }
    public float getTotal(){
        this.total = quantity*book.bookPrice;
        return total;
    }
    public void invoicePrinter(){
        // prints the invoice in some format
        System.out.printf("BookName:%s, Quantity:%d, Price:%s$", this.book.name, this.quantity, String.valueOf(this.total));
    }
    public void saveToFile(){
        // saves to file logic goes here
        System.out.println("Saved to file");
    }
}
/*
* We've defined three methods here mainly..
* 1) getTotal() -> for calc the total amount
* 2) invoicePrinter() -> for printing the invoice
* 3) saveToFile() -> for saving to file
* But if we want to print in some diff format... then (2) method needs to be changed -> 1st reason of change
* If in future we want to save invoice to Db not to file... then (3) methods needs to be change
* So our class dont follows SRP
* */