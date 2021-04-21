package servicesimplementation;

import model.Library;
import model.Person;

import java.util.Iterator;
import java.util.PriorityQueue;

public class ImplementationUsingPriorityQueue {

    PriorityQueue<Person> personQueueUsingPriority = new PriorityQueue<>();

    /**
     * For each book in the list of all book requests, add all the people requesting for the book to a priority queue
     * and give the book based on their level
     */

    public void giveBookBasedOnPriority() {
        Person.listOfAllBookRequests.forEach(book -> {
            Library.personQueue.forEach(person -> {
                if (book.equals(person.getBookRequestOfPerson())) {
                    personQueueUsingPriority.add(person);
                }
            });
            giveBook(personQueueUsingPriority);
            personQueueUsingPriority.clear();
        });
    }


    public void giveBook(PriorityQueue<Person> personQueueUsingPriority) {

        Iterator<Person> iterator = personQueueUsingPriority.iterator();
        while (iterator.hasNext()) {
            Person person = personQueueUsingPriority.poll();
            assert person != null;
            if (Library.getListOfBooks().contains(person.getBookRequestOfPerson())) {
                int bookIndex = Library.getListOfBooks().indexOf(person.getBookRequestOfPerson());
                if (Library.getListOfBooks().get(bookIndex).getNumberOfCopiesOfBook() != 0) {
                    int initialNumberOfCopiesOfBook = Library.getListOfBooks().get(bookIndex).getNumberOfCopiesOfBook();
                    int finalNumberOfCopiesOfBook = Library.getListOfBooks().get(bookIndex).getNumberOfCopiesOfBook() - 1;
                    Library.getListOfBooks().get(bookIndex).setNumberOfCopiesOfBook(finalNumberOfCopiesOfBook);

                    System.out.println("Using priority: " + person.getNameOfPerson() + ", a "
                            + person.getRoleOfPerson() + " has been given " + person.getBookRequestOfPerson().getTitleOfBook());

                    if (initialNumberOfCopiesOfBook - finalNumberOfCopiesOfBook == 1)
                        Library.getMapOfBorrowers().put(person.getNameOfPerson(), person.getBookRequestOfPerson().getTitleOfBook());
                } else {
                    System.out.println("Book Taken");
                }
            } else {
                System.out.println(person.getBookRequestOfPerson().getTitleOfBook() + " is not available in this library.");
            }
        }
    }
}
