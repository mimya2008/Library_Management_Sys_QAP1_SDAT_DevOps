package com.keyin.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String userId;
    private String name;
    private Set<String> borrowedBookIsbns;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBookIsbns = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean canBorrow() {
        return borrowedBookIsbns.size() < 2; // Max 2 books
    }

    public void borrowBook(String isbn) {
        if (canBorrow()) {
            borrowedBookIsbns.add(isbn);
        }
    }

    public void returnBook(String isbn) {
        borrowedBookIsbns.remove(isbn);
    }

    public boolean hasBorrowed(String isbn) {
        return borrowedBookIsbns.contains(isbn);
    }

    public Set<String> getBorrowedBookIsbns() {
        return borrowedBookIsbns;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedBookIsbns=" + borrowedBookIsbns +
                '}';
    }
}
