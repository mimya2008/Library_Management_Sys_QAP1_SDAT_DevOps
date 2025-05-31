package com.keyin.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("ISBN001", "Java Basics", true);

        assertEquals("ISBN001", book.getIsbn(), "ISBN should match");
        assertEquals("Java Basics", book.getTitle(), "Title should match");
        assertTrue(book.isAvailable(), "Book should be initially available");
    }

    @Test
    public void testBookAvailabilityToggle() {
        Book book = new Book("ISBN002", "Advanced Java", true);

        book.setAvailable(false);
        assertFalse(book.isAvailable(), "Book should be unavailable after setting to false");

        book.setAvailable(true);
        assertTrue(book.isAvailable(), "Book should be available again after setting to true");
    }

    @Test
    public void testToStringContainsBookInfo() {
        Book book = new Book("ISBN003", "Unit Testing", true);
        String output = book.toString();

        assertTrue(output.contains("ISBN003"), "Output should contain ISBN");
        assertTrue(output.contains("Unit Testing"), "Output should contain title");
        assertTrue(output.contains("Available: true"), "Output should mention availability");
    }
}
