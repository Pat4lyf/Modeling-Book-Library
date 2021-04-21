package servicesimplementation;

import model.Book;
import model.Library;
import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ImplementationUsingQueueTest {
    Person person = new Person("Bola", "Junior Student");
    Book book2 = new Book("The Orphan Boy", "Alex Jobs");
    Person person1 = new Person("Glory", "Senior Student");
    Person person2 = new Person("Pat", "Teacher");

    @BeforeEach
    void setUp() {
        person.requestForBook(book2);
        person1.requestForBook(book2);
        person2.requestForBook(book2);
    }

    @Test
    void testForGetLibraryTask() {
        Library.getAddingToBooks().addToListOfBooks(book2, 6);
        ImplementationUsingQueue implementationUsingQueue = new ImplementationUsingQueue();
        implementationUsingQueue.getLibraryTask().giveBook();

        assertEquals(3, Library.getMapOfBorrowers().size());
        assertNotEquals(0, Library.getMapOfBorrowers().size());


    }
}