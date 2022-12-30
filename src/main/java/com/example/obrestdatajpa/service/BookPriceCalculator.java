package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;

public class BookPriceCalculator {
    public static double calculatePrice(Book book) {
        Double price = book.getPrice();

        if (book.getPrice() > 300) {
            price *= 5;
        }
        // Shipping
        price += 2.99;
        return price;
    }

}
