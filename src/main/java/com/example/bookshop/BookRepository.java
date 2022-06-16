package com.example.bookshop;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> { //tu w <> podajemy klase ktora dodajemy do bazy + typ Id


}
