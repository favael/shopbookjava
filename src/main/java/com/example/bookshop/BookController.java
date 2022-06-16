package com.example.bookshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //mowi springowi ze klasa bedzie ogarniala naszego resta
@RequestMapping("/shop")
public class BookController {

//    List<String> stringList = new ArrayList<>();  //póki co to jest nasza baza danych

    //wstrzykiwanie zawartości ->

    @Autowired //info że wstrzykniete
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping ("/books")//aby spring wiedział że coś ma wyświetlać
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){ //dla tej metody podajemy caly obiekt ksiazki
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable long isbn){
        bookRepository.deleteById(isbn);
    }

}
