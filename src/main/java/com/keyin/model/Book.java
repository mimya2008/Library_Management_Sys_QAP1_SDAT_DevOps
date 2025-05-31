package com.keyin.model;

public class Book {
    private String isbn;
    private String title;
    private boolean available;

    public Book(String isbn, String title, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.available = available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Available: " + available;
    }
}
