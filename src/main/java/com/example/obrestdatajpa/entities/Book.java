package com.example.obrestdatajpa.entities;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "BOOKS")
public class Book {

    // atributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private Integer pages;
    private double price;
    private LocalDate releaseDate;
    private boolean onLIne;
    // constructors

    public Book(long l, String s, String desconocido, int i, double v, LocalDate now) {
    }

    public Book(long id, String title, String author, Integer pages, double price, LocalDate releaseDate, boolean onLIne) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.onLIne = onLIne;
    }

    // getters and setters
    // get
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    // Set
    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isOnLIne() {
        return onLIne;
    }

    public void setOnLIne(boolean onLIne) {
        this.onLIne = onLIne;
    }


    // toString()

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", onLIne=" + onLIne +
                '}';
    }
}
