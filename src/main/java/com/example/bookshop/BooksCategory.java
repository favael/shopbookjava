package com.example.bookshop;

public enum BooksCategory {


    HORROR("horror"),
    CRIMINAL("kryminal"),
    SCFI("scfi"),
    ROMANCE("romans"),
    FANTASY("fantastyka"),
    DRAMA("dramat"),
    COMEDY("komedia");



    private String categoryName;

    BooksCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
