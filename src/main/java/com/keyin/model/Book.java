package com.keyin.model;

/**
 * Represents a book in the library system.
 * Each book has an ISBN, a title, and an availability status.
 */

public class Book {
    private final String isbn;
    private final String title;
    private boolean available;

    /**
     * Constructs a new Book object.
     *
     * @param isbn      The International Standard Book Number (ISBN) of the book.
     * @param title     The title of the book.
     * @param available The availability status of the book (true if available, false if borrowed).
     * @throws IllegalArgumentException if isbn or title is null or empty.
     */

    public Book(String isbn, String title, boolean available) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be null or blank.");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank.");
        }

        this.isbn = isbn;
        this.title = title;
        this.available = available;
    }


    /**
     * Gets the ISBN of the book.
     *
     * @return The ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Gets the title of the book.
     *
     * @return The book title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Checks if the book is currently available.
     *
     * @return true if the book is available; false if it is borrowed.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param available true if the book should be marked as available; false if borrowed.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return A string containing the ISBN, title, and availability.
     */
    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Available: " + available;
    }
}