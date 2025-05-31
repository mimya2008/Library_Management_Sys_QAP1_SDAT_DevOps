package com.keyin.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String userId;
    private final String name;
    private final Set<String> borrowedBookIsbns;
    private static final int BORROW_LIMIT = 2;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBookIsbns = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean canBorrow() {
        return borrowedBookIsbns.size() < BORROW_LIMIT;
    }

    public void borrowBook(String isbn) {
        borrowedBookIsbns.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBookIsbns.remove(isbn);
    }

    public boolean hasBorrowed(String isbn) {
        return borrowedBookIsbns.contains(isbn);
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

