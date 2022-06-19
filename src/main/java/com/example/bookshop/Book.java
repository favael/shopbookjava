package com.example.bookshop;
//ad1


import lombok.*;

import javax.persistence.*;

@Entity(name = "book")
@Table(name = "books")
@Setter
@Getter
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "isbn")
    private long isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "booksCategory")
    private String booksCategory;
    @Column(name = "price")
    private double price;

    public Book(long isbn, String title, BooksCategory booksCategory, double prize) {
        this.isbn = isbn;
        this.title = title;
        this.booksCategory = booksCategory.getCategoryName();
        this.price = prize;
    }
}
