package com.keyin.service;

import com.keyin.model.Book;
import com.keyin.model.User;
import java.util.*;

public class LibraryService {
    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, User> users = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public boolean borrowBook(String userId, String isbn) {
        Book book = books.get(isbn);
        User user = users.get(userId);

        if (book == null || user == null || !book.isAvailable()) {
            return false;
        }

        book.setAvailable(false);
        user.borrowBook(isbn);
        return true;
    }

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

    public List<Book> searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean isBookAvailable(String isbn) {
        Book book = books.get(isbn);
        return book != null && book.isAvailable();
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void saveBooks() {
        // Stub for saving to file if needed later
        System.out.println("Books saved to file (stub)");
    }

    public void saveUsers() {
        // Stub for saving to file if needed later
        System.out.println("Users saved to file (stub)");
    }
}
