package com.keyin.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Book} class.
 * This class tests the correctness of the Book model including object creation,
 * state changes (availability), and string representation.
 */
public class BookTest {

    /**
     * Test to verify correct creation of a Book object.
     * It checks whether the constructor sets the fields properly.
     */
    @Test
    public void testBookCreation() {
        Book book = new Book("ISBN001", "Java Basics", true);

        assertEquals("ISBN001", book.getIsbn(), "ISBN should match");
        assertEquals("Java Basics", book.getTitle(), "Title should match");
        assertTrue(book.isAvailable(), "Book should be initially available");
    }

    /**
     * Test to verify that the availability status of a book
     * can be toggled correctly using the setter method.
     */
    @Test
    public void testBookAvailabilityToggle() {
        Book book = new Book("ISBN002", "Advanced Java", true);

        // Set book to unavailable and verify
        book.setAvailable(false);
        assertFalse(book.isAvailable(), "Book should be unavailable after setting to false");

        // Set book back to available and verify
        book.setAvailable(true);
        assertTrue(book.isAvailable(), "Book should be available again after setting to true");
    }

    /**
     * Test to verify that the toString method provides a string
     * that contains all relevant information about the book.
     */
    @Test
    public void testToStringContainsBookInfo() {
        Book book = new Book("ISBN003", "Unit Testing", true);
        String output = book.toString();

        assertTrue(output.contains("ISBN003"), "Output should contain ISBN");
        assertTrue(output.contains("Unit Testing"), "Output should contain title");
        assertTrue(output.contains("Available: true"), "Output should mention availability");
    }
}
