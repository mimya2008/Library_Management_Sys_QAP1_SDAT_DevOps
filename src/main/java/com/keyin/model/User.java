package com.keyin.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a library user who can borrow books.
 * Each user has a unique ID, name, and a set of borrowed book ISBNs.
 */
public class User {
    private final String userId;
    private final String name;
    private final Set<String> borrowedBookIsbns;

    /**
     * Constructs a new User.
     *
     * @param userId The unique ID of the user.
     * @param name   The full name of the user.
     * @throws IllegalArgumentException if userId or name is null or blank.
     */
    public User(String userId, String name) {
        if (userId == null || userId.isBlank()) {
            throw new IllegalArgumentException("User ID cannot be null or blank.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        this.userId = userId;
        this.name = name;
        this.borrowedBookIsbns = new HashSet<>();
    }

    /**
     * Returns the user's ID.
     *
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Returns the user's name.
     *
     * @return The user's full name.
     */
    public String getName() {
        return name;
    }

    /**
     * Determines whether the user can borrow more books.
     * The maximum allowed is 2 borrowed books.
     *
     * @return true if the user can borrow more books; false otherwise.
     */
    public boolean canBorrow() {
        return borrowedBookIsbns.size() < 2;
    }

    /**
     * Borrows a book by its ISBN, if the user hasn't reached the borrowing limit.
     *
     * @param isbn The ISBN of the book to borrow.
     */
    public void borrowBook(String isbn) {
        if (canBorrow()) {
            borrowedBookIsbns.add(isbn);
        }
    }

    /**
     * Returns a book by its ISBN.
     *
     * @param isbn The ISBN of the book to return.
     */
    public void returnBook(String isbn) {
        borrowedBookIsbns.remove(isbn);
    }

    /**
     * Checks whether the user has borrowed a book with the specified ISBN.
     *
     * @param isbn The ISBN to check.
     * @return true if the user has borrowed the book; false otherwise.
     */
    public boolean hasBorrowed(String isbn) {
        return borrowedBookIsbns.contains(isbn);
    }

    /**
     * Returns a set of ISBNs of books currently borrowed by the user.
     *
     * @return A set of borrowed book ISBNs.
     */
    public Set<String> getBorrowedBookIsbns() {
        return borrowedBookIsbns;
    }

    /**
     * Returns a string representation of the user.
     *
     * @return A string with user ID, name, and borrowed book ISBNs.
     */
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", borrowedBookIsbns=" + borrowedBookIsbns +
                '}';
    }
}
