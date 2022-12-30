package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {
        // Crear el esenario y configuracion de la prueba
        Book book = new Book(1l, "Harry Potter and the Philosopher's Stone","desconocido",900,49.99, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        // Ejecutar el comportamiento
        double price = calculator.calculatePrice(book);

        // Comprobamos el resultado de la pruebas
        assertTrue(price > 0);
        assertTrue(price > book.getPrice());

    }
}