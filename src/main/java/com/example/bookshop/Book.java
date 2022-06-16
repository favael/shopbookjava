package com.example.bookshop;
//ad1


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

    public Book(long isbn, String title, BooksCategory booksCategory, double prize) {
        this.isbn = isbn;
        this.title = title;
        this.booksCategory = booksCategory.getCategoryName();
        this.price = prize;
    }
}
