package com.keyin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("U001", "Alice");
    }

    @Test
    void testUserCanBorrowInitially() {
        // Positive case: new user should be able to borrow
        assertTrue(user.canBorrow(), "New user should be able to borrow books.");
    }

    @Test
    void testBorrowBookReducesBorrowAvailability() {
        user.borrowBook("ISBN001");
        user.borrowBook("ISBN002");

        // Should reach borrow limit
        assertFalse(user.canBorrow(), "User should not be able to borrow more than 2 books.");
    }

    @Test
    void testReturnBookFreesUpBorrowLimit() {
        user.borrowBook("ISBN001");
        user.borrowBook("ISBN002");
        user.returnBook("ISBN001");

        // Should allow borrowing again
        assertTrue(user.canBorrow(), "User should be able to borrow again after returning a book.");
    }

    @Test
    void testHasBorrowedReturnsTrueForBorrowedBook() {
        user.borrowBook("ISBN123");
        assertTrue(user.hasBorrowed("ISBN123"), "User should have borrowed the book.");
    }

    @Test
    void testHasBorrowedReturnsFalseForNonBorrowedBook() {
        assertFalse(user.hasBorrowed("ISBN999"), "User should not have borrowed the book.");
    }

    @Test
    void testToStringContainsUserInfo() {
        String output = user.toString();
        assertTrue(output.contains("U001"));
        assertTrue(output.contains("Alice"));
        assertTrue(output.contains("borrowedBookIsbns"));
    }
}

