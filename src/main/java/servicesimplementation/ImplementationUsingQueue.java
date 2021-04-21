package servicesimplementation;

import model.Library;
import services.LibraryTask;

public class ImplementationUsingQueue {

    LibraryTask libraryTask = () -> {
        if (Library.personQueue.size() >= 3) {
            Library.personQueue.forEach(person -> {
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
            });
        } else {
            System.out.println("The size of the queue must be 3 and above, before processing requests.");
        }
    };

    public LibraryTask getLibraryTask() {
        return libraryTask;
    }
}
