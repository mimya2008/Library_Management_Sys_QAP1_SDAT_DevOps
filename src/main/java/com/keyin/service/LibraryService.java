package com.keyin.service;

import com.keyin.model.Book;
import com.keyin.model.User;

import java.util.*;

/**
 * Service class that handles the core logic for managing books and users in the library system.
 * Supports operations such as borrowing, returning, adding, and searching books.
 */
public class LibraryService {

    // Maps ISBN to Book
    private final Map<String, Book> books = new HashMap<>();

    // Maps User ID to User
    private final Map<String, User> users = new HashMap<>();

    /**
     * Adds a new book to the library's collection.
     *
     * @param book The book to be added.
     * @throws IllegalArgumentException if the book is null or already exists.
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        books.put(book.getIsbn(), book);
    }

    /**
     * Registers a new user to the library system.
     *
     * @param user The user to be added.
     * @throws IllegalArgumentException if the user is null or already exists.
     */
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        users.put(user.getUserId(), user);
    }

    /**
     * Allows a user to borrow a book if it's available and the user is eligible.
     *
     * @param userId The ID of the user.
     * @param isbn   The ISBN of the book to borrow.
     * @return true if the book was successfully borrowed, false otherwise.
     */
    public boolean borrowBook(String userId, String isbn) {
        Book book = books.get(isbn);
        User user = users.get(userId);

        if (book == null || user == null || !book.isAvailable() || !user.canBorrow()) {
            return false;
        }

        book.setAvailable(false);
        user.borrowBook(isbn);
        return true;
    }

    /**
     * Allows a user to return a borrowed book.
     *
     * @param userId The ID of the user.
     * @param isbn   The ISBN of the book to return.
     * @return true if the book was successfully returned, false otherwise.
     */
    public boolean returnBook(String userId, String isbn) {
        Book book = books.get(isbn);
        User user = users.get(userId);

        if (book == null || user == null || !user.hasBorrowed(isbn)) {
            return false;
        }

        book.setAvailable(true);
        user.returnBook(isbn);
        return true;
    }

    /**
     * Searches for books whose titles contain the given search string (case-insensitive).
     *
     * @param title The title or keyword to search for.
     * @return A list of matching books.
     */
    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    /**
     * Checks if a book with the given ISBN is available for borrowing.
     *
     * @param isbn The ISBN of the book to check.
     * @return true if the book exists and is available; false otherwise.
     */
    public boolean isBookAvailable(String isbn) {
        Book book = books.get(isbn);
        return book != null && book.isAvailable();
    }

    /**
     * Retrieves all books in the library.
     *
     * @return A list of all books.
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    /**
     * Retrieves all registered users in the library system.
     *
     * @return A list of all users.
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}
