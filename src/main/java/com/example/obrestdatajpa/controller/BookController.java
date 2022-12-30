package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    // Inyectar el repository de la clase -> lo hace el framework Spring
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CRUD de la entidad book

    // Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    // Buscar un solo libro segun su ID
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
         else
            return ResponseEntity.notFound().build();
    }

    // Crear un nuevo libro
    @PostMapping("/api/books")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        if (book.getId() > 0){
            return ResponseEntity.badRequest().build();
        }
        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);
    }

    // Actualizar un libro existente
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() < 0){
            return ResponseEntity.badRequest().build();
        } else
        if (!bookRepository.existsById(book.getId()) ) {
            // log.warn("Libro no existente");
            return ResponseEntity.notFound().build();
        }

        Book savedBook = bookRepository.save(book);
        return ResponseEntity.ok(savedBook);

    }

    // Borrar un libro en la base de datos
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if (id < 0){
            return ResponseEntity.badRequest().build();
        } else
        if (!bookRepository.existsById(id) ) {
            // log.warn("Libro no existente");
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
