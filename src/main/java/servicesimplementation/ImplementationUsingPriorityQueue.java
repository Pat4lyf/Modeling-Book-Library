package servicesimplementation;

import model.Book;
import model.Library;
import model.Person;
import services.LibraryTask;

import java.util.Iterator;
import java.util.PriorityQueue;

public class ImplementationUsingPriorityQueue {

    PriorityQueue<Person> personQueueUsingPriority = new PriorityQueue<>();

    /**
     * For each person in the queue, check if the bookrequest of the person
     * is same as others in the queue. if this is so, use priority
     * in giving out the book. if not, give the book to the person and move to
     * the next.
     */
    public void giveBookBasedOnPriority() {

        for (Person person : Library.personQueue) {
            if (Person.mapOfAllBookRequests.get(person.getBookRequestOfPerson()) == 1) {
                libraryTask.giveBook();
            } else {
                /**
                 * how to add only the people requesting for that book to the priority queue
                 */

                personQueueUsingPriority.add(person);
            }
        }
//        Library.personQueue.forEach(p -> {
//            if (Person.mapOfAllBookRequests.get(p.getBookRequestOfPerson()) == 1) {
//                libraryTask.giveBook();
//            } else {
//                /**
//                 * how to add only the people requesting for that book to the priority queue
//                 */
//
//                personQueueUsingPriority.add(p);
//            }
//        });
        giveBook(personQueueUsingPriority);
        personQueueUsingPriority.clear();
    }


    public void giveBook(PriorityQueue<Person> personQueueUsingPriority) {

            Iterator<Person> iterator = personQueueUsingPriority.iterator();
            while (iterator.hasNext()) {
                Person person = personQueueUsingPriority.poll();
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


    LibraryTask libraryTask = () -> {
        Person person = Library.personQueue.poll();
        if (Library.getListOfBooks().contains(person.getBookRequestOfPerson())) {
            int bookIndex = Library.getListOfBooks().indexOf(person.getBookRequestOfPerson());
            if (Library.getListOfBooks().get(bookIndex).getNumberOfCopiesOfBook() != 0) {
                int finalNumberOfCopiesOfBook = Library.getListOfBooks().get(bookIndex).getNumberOfCopiesOfBook() - 1;
                Library.getListOfBooks().get(bookIndex).setNumberOfCopiesOfBook(finalNumberOfCopiesOfBook);
                Library.personQueue.poll();
                System.out.println("Using queue: " + person.getNameOfPerson() + ", a "
                        + person.getRoleOfPerson() + " has been given " + person.getBookRequestOfPerson().getTitleOfBook());

                Library.getMapOfBorrowers().put(person.getNameOfPerson(), person.getBookRequestOfPerson().getTitleOfBook());
            } else {
                System.out.println("Book Taken");
            }
        } else {
            System.out.println(person.getBookRequestOfPerson().getTitleOfBook() + " is not available in this library.");
        }
    };

}
