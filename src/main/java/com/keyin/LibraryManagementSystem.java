package com.keyin;

import com.keyin.model.Book;
import com.keyin.model.User;
import com.keyin.service.LibraryService;

import java.util.List;

/**
 * Entry point for the Library Management System application.
 * Demonstrates the basic functionality of the system including:
 * - Adding books and users
 * - Borrowing and returning books
 * - Listing books and users
 *
 * This example uses hardcoded data to simulate a real use case.
 */
public class LibraryManagementSystem {

    /**
     * Main method to run the library simulation.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Create the LibraryService instance (core logic handler)
        LibraryService library = new LibraryService();

        // --- Step 1: Add sample books and users ---
        Book book1 = new Book("ISBN001", "Java Basics", true);
        Book book2 = new Book("ISBN002", "Advanced Java", true);

        User user1 = new User("U001", "Alice");
        User user2 = new User("U002", "Bob");

        library.addBook(book1);
        library.addBook(book2);
        library.addUser(user1);
        library.addUser(user2);

        // --- Step 2: Simulate a book borrowing ---
        System.out.println("\nBorrowing book ISBN001 by U001...");
        boolean borrowSuccess = library.borrowBook("U001", "ISBN001");
        System.out.println(borrowSuccess ? "Borrow successful." : "Borrow failed.");

        // --- Step 3: Display current books ---
        System.out.println("\n--- Book List After Borrowing ---");
        printBooks(library.getAllBooks());

        // --- Step 4: Display current users ---
        System.out.println("\n--- User List ---");
        printUsers(library.getAllUsers());

        // --- Step 5: Simulate returning a book ---
        System.out.println("\nReturning book ISBN001 by U001...");
        boolean returnSuccess = library.returnBook("U001", "ISBN001");
        System.out.println(returnSuccess ? "Return successful." : "Return failed.");

        // --- Step 6: Display books after return ---
        System.out.println("\n--- Book List After Returning ---");
        printBooks(library.getAllBooks());

        // --- Step 7: Display users again ---
        System.out.println("\n--- User List ---");
        printUsers(library.getAllUsers());

        // --- Step 8: Search books by title keyword ---
        System.out.println("\nSearching for books with title containing 'Java'...");
        List<Book> foundBooks = library.searchByTitle("Java");
        if (foundBooks.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Books found:");
            printBooks(foundBooks);
        }

    }

    /**
     * Utility method to print the list of books in the library.
     *
     * @param books A list of {@link Book} objects to display.
     */
    private static void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    /**
     * Utility method to print the list of users in the library.
     *
     * @param users A list of {@link User} objects to display.
     */
    private static void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
