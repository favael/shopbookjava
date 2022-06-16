package com.example.bookshop;

public enum BooksCategory {

    HORROR("horror"),
    CRIMINAL("kryminal"),
    SCIFI("sajensfikszyn"),
    ROMANCE("romansidlo"),
    DRAMA("dramat");

    String categoryName;

    BooksCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}
