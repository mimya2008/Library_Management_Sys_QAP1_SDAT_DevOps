package com.keyin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link User} class.
 * This test class verifies the behavior of user-related operations such as borrowing,
 * returning books, enforcing borrowing limits, and user information display.
 */
public class UserTest {

    private User user;

    /**
     * Initializes a User object before each test method.
     */
    @BeforeEach
    void setUp() {
        user = new User("U001", "Alice");
    }

    /**
     * Test to ensure a new user is allowed to borrow books initially.
     */
    @Test
    void testUserCanBorrowInitially() {
        assertTrue(user.canBorrow(), "New user should be able to borrow books.");
    }

    /**
     * Test to check that borrowing books reduces the number of borrowable slots.
     */
    @Test
    void testBorrowBookReducesBorrowAvailability() {
        user.borrowBook("ISBN001");
        assertTrue(user.canBorrow(), "User should still be able to borrow a second book.");

        user.borrowBook("ISBN002");
        assertFalse(user.canBorrow(), "User should not be able to borrow more than 2 books.");
    }

    /**
     * Test to confirm that returning a book restores the ability to borrow again.
     */
    @Test
    void testReturnBookFreesUpBorrowLimit() {
        user.borrowBook("ISBN001");
        user.borrowBook("ISBN002");

        user.returnBook("ISBN001");

        assertTrue(user.canBorrow(), "User should be able to borrow again after returning a book.");
    }

    /**
     * Test to verify that hasBorrowed returns true for a book that was borrowed.
     */
    @Test
    void testHasBorrowedReturnsTrueForBorrowedBook() {
        user.borrowBook("ISBN123");

        assertTrue(user.hasBorrowed("ISBN123"), "User should have borrowed ISBN123.");
    }

    /**
     * Test to verify that hasBorrowed returns false for books never borrowed.
     */
    @Test
    void testHasBorrowedReturnsFalseForNonBorrowedBook() {
        assertFalse(user.hasBorrowed("ISBN999"), "User has not borrowed ISBN999.");
    }

    /**
     * Test to ensure that the borrowing limit (2 books) is enforced.
     * Third book should not be borrowed.
     */
    @Test
    void testBorrowedBookLimitEnforced() {
        user.borrowBook("ISBN001");
        user.borrowBook("ISBN002");

        user.borrowBook("ISBN003"); // Should not be added

        Set<String> borrowed = user.getBorrowedBookIsbns();

        assertEquals(2, borrowed.size(), "User should only be able to borrow 2 books max.");
        assertFalse(borrowed.contains("ISBN003"), "Third book should not be borrowed.");
    }

    /**
     * Test to confirm that toString() output includes user ID, name, and borrowed book details.
     */
    @Test
    void testToStringIncludesUserIdAndName() {
        String output = user.toString();

        assertTrue(output.contains("U001"), "toString() should contain user ID.");
        assertTrue(output.contains("Alice"), "toString() should contain user name.");
        assertTrue(output.contains("borrowedBookIsbns"), "toString() should list borrowed books.");
    }
}
