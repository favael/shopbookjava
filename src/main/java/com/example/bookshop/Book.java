package com.example.bookshop;
//ad 1

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity  // dla samego springa jest Entity
@Setter
@Getter
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long isbn;
    private String title;
    private String booksCategory;
    private double price;

    public Book(long isbn, String title, BooksCategory booksCategory, double price) {
        this.isbn = isbn;
        this.title = title;
        this.booksCategory = booksCategory.getCatagoryName();
        this.price = price;
    }
}
