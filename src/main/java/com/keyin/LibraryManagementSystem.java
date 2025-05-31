package com.keyin;

import com.keyin.model.Book;
import com.keyin.model.User;
import com.keyin.service.LibraryService;

import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // File paths
        String booksPath = "books.txt";
        String usersPath = "users.txt";

        // Service instance
        LibraryService library = new LibraryService();

        // Hardcoded books and users
        Book book1 = new Book("ISBN001", "Java Basics", false);
        Book book2 = new Book("ISBN002", "Advanced Java", false);
        User user1 = new User("U001", "Alice");
        User user2 = new User("U002", "Bob");

        // Add to library
        library.addBook(book1);
        library.addBook(book2);
        library.addUser(user1);
        library.addUser(user2);

        // Simulate borrowing
        library.borrowBook("U001", "ISBN001");

        // Display books
        System.out.println("\n--- Book List ---");
        List<Book> books = library.getAllBooks();
        for (Book b : books) {
            System.out.println(b);
        }

        // Display users
        System.out.println("\n--- User List ---");
        List<User> users = library.getAllUsers();
        for (User u : users) {
            System.out.println(u);
        }

        // Save to file
        library.saveBooks();
        library.saveUsers();

        System.out.println("\nData saved. Check books.txt and users.txt.");
    }
}
