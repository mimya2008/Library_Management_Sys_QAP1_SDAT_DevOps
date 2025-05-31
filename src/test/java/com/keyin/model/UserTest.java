package com.keyin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("U001", "Alice");
    }

    @Test
    void testUserCanBorrowInitially() {
        assertTrue(user.canBorrow(), "New user should be able to borrow books.");
    }

    @Test
    void testBorrowBookReducesBorrowAvailability() {
        user.borrowBook("ISBN001");
        assertTrue(user.canBorrow(), "User should still be able to borrow a second book.");
        user.borrowBook("ISBN002");
        assertFalse(user.canBorrow(), "User should not be able to borrow more than 2 books.");
    }

    @Test
    void testReturnBookFreesUpBorrowLimit() {
        user.borrowBook("ISBN001");
        user.borrowBook("ISBN002");
        user.returnBook("ISBN001");
        assertTrue(user.canBorrow(), "User should be able to borrow again after returning a book.");
    }

    @Test
    void testHasBorrowedReturnsTrueForBorrowedBook() {
        user.borrowBook("ISBN123");
        assertTrue(user.hasBorrowed("ISBN123"), "User should have borrowed ISBN123.");
    }

    @Test
    void testHasBorrowedReturnsFalseForNonBorrowedBook() {
        assertFalse(user.hasBorrowed("ISBN999"), "User has not borrowed ISBN999.");
    }

    @Test
    void testBorrowedBookLimitEnforced() {
        user.borrowBook("ISBN001");
        user.borrowBook("ISBN002");
        user.borrowBook("ISBN003"); // should not be added
        Set<String> borrowed = user.getBorrowedBookIsbns();
        assertEquals(2, borrowed.size(), "User should only be able to borrow 2 books max.");
        assertFalse(borrowed.contains("ISBN003"), "Third book should not be borrowed.");
    }

    @Test
    void testToStringIncludesUserIdAndName() {
        String output = user.toString();
        assertTrue(output.contains("U001"), "toString() should contain user ID.");
        assertTrue(output.contains("Alice"), "toString() should contain user name.");
        assertTrue(output.contains("borrowedBookIsbns"), "toString() should list borrowed books.");
    }
}
