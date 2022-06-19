package com.example.bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class BookController {

    //    private List<String> stringList = new ArrayList<>();
    @Autowired
    HibernateBookRepository hibernateBookRepository;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return hibernateBookRepository.findAll();
    }

    @GetMapping("/books/byCategory/{category}")
    public List<Book> findBookByCategory(@PathVariable String category) {
        return hibernateBookRepository.findBooksByCategory(category);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        hibernateBookRepository.save(book);
        return book;
    }

    @DeleteMapping("/{isbn}")
    public long deleteBook(@PathVariable long isbn) {
        hibernateBookRepository.deleteBookByIsbn(isbn);
        return isbn;
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book) {
        hibernateBookRepository.updateBook(book);
        return book;
    }

    @GetMapping("/books/{isbn}")
    public Book findByIsbn(@PathVariable Integer isbn) {
        return hibernateBookRepository.findBookByIsbn(isbn);
    }

}
