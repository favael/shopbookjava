package com.example.bookshop;

import java.util.List;

public interface BookRepository {

    void save(Book book);
    List<Book> findAll();
    Book findBookByIsbn(long isbn);
    long deleteBookByIsbn(long isbn);
    Book updateBook (Book book);
    List<Book> findBooksByCategory(String category);

}
