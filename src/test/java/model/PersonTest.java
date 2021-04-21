package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import servicesimplementation.ImplementationUsingQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PersonTest {
    static Person person = new Person("Bola", "Junior Student");
    static Book book2 = new Book("The Orphan Boy", "Alex Jobs");
    static Person person1 = new Person("Glory", "Senior Student");
    static Person person2 = new Person("Pat", "Teacher");

    @BeforeAll
    static void setUp() {
        Person.listOfAllBookRequests.removeAll(Person.listOfAllBookRequests);
        person.requestForBook(book2);
        person1.requestForBook(book2);
        person2.requestForBook(book2);
    }


    @Test
    void testForGetBookRequestOfPerson() {
        assertEquals("The Orphan Boy", person.getBookRequestOfPerson().getTitleOfBook());
        assertNotEquals("Blue Band", person.getBookRequestOfPerson().getTitleOfBook());

    }

    @Test
    void testForRequestForBook() {
        assertEquals(3, Library.personQueue.size());
        assertNotEquals(0, Library.personQueue.size());

        assertEquals(1, Person.listOfAllBookRequests.size());
        assertNotEquals(3, Person.listOfAllBookRequests.size());
    }


    @Test
    void testForReturnBook() {
        Library.getAddingToBooks().addToListOfBooks(book2, 6);
        ImplementationUsingQueue implementationUsingQueue = new ImplementationUsingQueue();
        implementationUsingQueue.getLibraryTask().giveBook();

        assertEquals(3, Library.mapOfBorrowers.size());
        assertNotEquals(0, Library.mapOfBorrowers.size());

        person.returnBook();

        assertEquals(2, Library.mapOfBorrowers.size());
        assertNotEquals(3, Library.mapOfBorrowers.size());

    }
}