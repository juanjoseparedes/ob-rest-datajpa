package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

	    // CRUD
		// create a new book
		Book book1 = new Book(-1, "LA CARA OCUALTA DELPHI 4","IAM MARTEENS",840, 49.99, LocalDate.of(2004,10,22), true);
		Book book2 = new Book(-1,  "LA BIBLIA DE DELPHI", "MARCO CANTU", 540, 29.99, LocalDate.of(2008,1,30), false);
		repository.save(book1);
	    repository.save(book2);

		System.out.println(repository.findAll());

		// save the book

		// get the book by id

		// delete the book

	}

}
