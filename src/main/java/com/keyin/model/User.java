package com.keyin.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String userId;
    private String name;
    private Set<String> borrowedBooks;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(String isbn) {
        borrowedBooks.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }

    public boolean hasBorrowed(String isbn) {
        return borrowedBooks.contains(isbn);
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < 5; // optional rule
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Borrowed Books: " + borrowedBooks;
    }
}
