package com.keyin.service;

import com.keyin.model.Book;
import com.keyin.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link LibraryService} class.
 * This class validates core functionalities including book borrowing,
 * returning, searching by title, and adding books and users.
 */
public class LibraryServiceTest {

    private LibraryService libraryService;

    /**
     * Initializes a LibraryService instance and populates it with
     * sample books and users before each test.
     */
    @BeforeEach
    public void setUp() {
        libraryService = new LibraryService();

        // Add sample books
        libraryService.addBook(new Book("ISBN001", "Java Basics", true));
        libraryService.addBook(new Book("ISBN002", "Advanced Java", true));

        // Add sample users
        libraryService.addUser(new User("U001", "Alice"));
        libraryService.addUser(new User("U002", "Bob"));
    }

    /**
     * Test successful borrowing of a book.
     * Ensures the book becomes unavailable afterward.
     */
    @Test
    public void testBorrowBook_Success() {
        boolean borrowed = libraryService.borrowBook("U001", "ISBN001");

        assertTrue(borrowed, "Book should be successfully borrowed.");
        assertFalse(libraryService.isBookAvailable("ISBN001"), "Book should no longer be available.");
    }

    /**
     * Test borrowing a book that has already been borrowed.
     * Expected to fail for the second user.
     */
    @Test
    public void testBorrowBook_BookNotAvailable() {
        libraryService.borrowBook("U001", "ISBN001");

        boolean secondBorrow = libraryService.borrowBook("U002", "ISBN001");

        assertFalse(secondBorrow, "Second user should not be able to borrow an unavailable book.");
    }

    /**
     * Test attempting to borrow a book using a non-existent user ID.
     */
    @Test
    public void testBorrowBook_UserNotFound() {
        boolean result = libraryService.borrowBook("U999", "ISBN001");

        assertFalse(result, "Borrow attempt should fail for non-existent user.");
    }

    /**
     * Test attempting to borrow a book using an invalid ISBN.
     */
    @Test
    public void testBorrowBook_BookNotFound() {
        boolean result = libraryService.borrowBook("U001", "INVALID_ISBN");

        assertFalse(result, "Borrow attempt should fail for non-existent book.");
    }

    /**
     * Test successful return of a previously borrowed book.
     * Ensures the book becomes available again.
     */
    @Test
    public void testReturnBook_Success() {
        libraryService.borrowBook("U001", "ISBN001");

        boolean returned = libraryService.returnBook("U001", "ISBN001");

        assertTrue(returned, "Book should be successfully returned.");
        assertTrue(libraryService.isBookAvailable("ISBN001"), "Book should be available again after return.");
    }

    /**
     * Test returning a book that was never borrowed.
     */
    @Test
    public void testReturnBook_NotBorrowed() {
        boolean returned = libraryService.returnBook("U001", "ISBN001");

        assertFalse(returned, "Return should fail for a book that was not borrowed.");
    }

    /**
     * Test searching for books using a title keyword.
     * Ensures all matching titles are returned.
     */
    @Test
    public void testSearchByTitle() {
        List<Book> results = libraryService.searchByTitle("Java");

        assertEquals(2, results.size(), "Should return two books matching the title keyword 'Java'.");
    }

    /**
     * Test adding a new book and user to the library system.
     * Verifies correct size and availability afterward.
     */
    @Test
    public void testAddBookAndUser() {
        Book newBook = new Book("ISBN003", "Python Programming", true);
        User newUser = new User("U003", "Charlie");

        libraryService.addBook(newBook);
        libraryService.addUser(newUser);

        assertTrue(libraryService.isBookAvailable("ISBN003"), "Newly added book should be available.");
        assertEquals(3, libraryService.getAllBooks().size(), "There should now be 3 books in the system.");
        assertEquals(3, libraryService.getAllUsers().size(), "There should now be 3 users in the system.");
    }
}
