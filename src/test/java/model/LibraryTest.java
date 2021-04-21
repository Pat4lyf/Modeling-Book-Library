package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import servicesimplementation.ImplementationUsingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LibraryTest {

    static Person person = new Person("Bola", "Junior Student");
    static Book book2 = new Book("The Orphan Boy", "Alex Jobs");
    static Person person1 = new Person("Glory", "Senior Student");
    static Person person2 = new Person("Pat", "Teacher");

    @BeforeAll
    static void setUp() {
        person.requestForBook(book2);
        person1.requestForBook(book2);
        person2.requestForBook(book2);
        Library.getAddingToBooks().addToListOfBooks(book2, 6);
    }


    @Test
    void testForGetMapOfBorrowers() {
        ImplementationUsingQueue implementationUsingQueue = new ImplementationUsingQueue();
        implementationUsingQueue.getLibraryTask().giveBook();
        assertEquals(3, Library.getMapOfBorrowers().size());
        assertNotEquals(0, Library.getMapOfBorrowers().size());
    }


    @Test
    void testForGetListOfBooks() {
        System.out.println(Library.getListOfBooks());
//        assertEquals(1, Library.listOfBooks.size());
        assertNotEquals(3, Library.getListOfBooks().size());
    }


    @Test
    void testForGetAddingToBooks() {
        Library.getAddingToBooks().addToListOfBooks(book2, 6);

        int bookIndex = Library.getListOfBooks().indexOf(book2);
        assertEquals(12, Library.getListOfBooks().get(bookIndex).getNumberOfCopiesOfBook());
        assertNotEquals(6, Library.getListOfBooks().get(bookIndex).getNumberOfCopiesOfBook());

    }
}