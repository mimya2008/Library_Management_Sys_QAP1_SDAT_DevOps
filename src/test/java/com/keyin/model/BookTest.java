package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("1984", "George Orwell", true);
        assertEquals("1984", book.getTitle());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBookAvailabilityUpdate() {
        Book book = new Book("1984", "George Orwell", true);
        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }
}

