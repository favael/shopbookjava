package com.example.bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shop")
public class BookControler {

    //List<String> stringList = new ArrayList<>();
    @Autowired
    private final BookRepository bookRepository;

    public BookControler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getBooks ()    {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook (@RequestBody Book book){
        bookRepository.save(book);
        return book;
    }
    @DeleteMapping("/{isbn}")
    public Optional<Book> deleteBook(@PathVariable long isbn){
        Optional<Book> byId = bookRepository.findById(isbn);
        bookRepository.deleteById(isbn);
        return byId;
    }
}
