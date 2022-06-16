package com.example.bookshop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private long ISBN;
    private String title;
    private String booksCategory;
    private double price;

    public Book(long ISBN, String title, BooksCategory booksCategory, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.booksCategory = booksCategory.getCategoryName();
        this.price = price;
    }
}

