package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {
    Book book1 = new Book("Sugar Girl", "Bibs Bush");

    @Test
    void testForGetTitleOfBook() {
        assertEquals("Sugar Girl", book1.getTitleOfBook());
        assertNotEquals("Blue Band", book1.getTitleOfBook());
    }

    @Test
    void testForSetTitleOfBook() {
        book1.setTitleOfBook("Big Hero");
        assertEquals("Big Hero", book1.getTitleOfBook());
        assertNotEquals("Sugar Girl", book1.getTitleOfBook());
    }

    @Test
    void testForGetAuthorOfBook() {
        assertEquals("Bibs Bush", book1.getAuthorOfBook());
        assertNotEquals("Tom Clark", book1.getAuthorOfBook());
    }

    @Test
    void testForSetAuthorOfBook() {
        book1.setAuthorOfBook("Tom Clark");
        assertEquals("Tom Clark", book1.getAuthorOfBook());
        assertNotEquals("Bibs Bush", book1.getAuthorOfBook());
    }

    @Test
    void testForGetNumberOfCopiesOfBook() {
        Library.getAddingToBooks().addToListOfBooks(book1, 5);
        assertEquals(5, book1.getNumberOfCopiesOfBook());
        assertNotEquals(8, book1.getNumberOfCopiesOfBook());
    }

    @Test
    void testForSetNumberOfCopiesOfBook() {
        Library.getAddingToBooks().addToListOfBooks(book1, 5);
        book1.setNumberOfCopiesOfBook(8);
        assertEquals(8, book1.getNumberOfCopiesOfBook());
        assertNotEquals(5, book1.getNumberOfCopiesOfBook());
    }
}