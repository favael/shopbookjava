package com.example.bookshop;

public enum BooksCategory {

    HORROR("horror"),
    CRIMINAL("kryminal"),
    SCIFI("scifi"),
    FANTASY("fantastyka"),
    ROMANS("romans"),
    DRAMA("dramat");

    String catagoryName;
    //aby kazdy obiekt wiedzial ze ma swoj opis dodajemy konstruktor


    BooksCategory(String catagoryName) {
        this.catagoryName = catagoryName;
    }
}
