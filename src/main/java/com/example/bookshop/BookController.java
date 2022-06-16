package com.example.bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop")
public class BookController {

//    private List<String> stringList = new ArrayList<>();
    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{category}")
    public List<Book> findBookByCategory (@PathVariable String category){
        return bookRepository.findAll().stream()
                .filter(book -> book.getBooksCategory().equals(category)).collect(Collectors.toList());
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }
    @DeleteMapping("/{isbn}")
    public Optional<Book> deleteBook(@PathVariable long isbn) {
        Optional<Book> byId = bookRepository.findById(isbn);
        bookRepository.deleteById(isbn);
        return byId;
    }

    @PutMapping
    public Book updateBook (@RequestBody Book book){
        Book bookFromDB = bookRepository.getOne(book.getIsbn());
        bookFromDB.setTitle(book.getTitle());
        bookFromDB.setPrice(book.getPrice());
        bookFromDB.setBooksCategory(book.getBooksCategory());
        bookRepository.save(bookFromDB);
        return book;
    }
}
