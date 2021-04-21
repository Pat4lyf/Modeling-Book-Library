package model;


import services.AddingToBooks;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Library {
    public static Queue<Person> personQueue = new ConcurrentLinkedQueue<>();
    /**
     * defining the fields of the library class
     */
    static List<Book> listOfBooks = new ArrayList<>();
    static Map<String, String> mapOfBorrowers = new HashMap<>();
    /**
     * Method to add to the list of books in the library
     */
    static AddingToBooks addingToBooks = (Book book, int bookQuantity) -> {
        if (listOfBooks.contains(book)) {
            int totalNumberOfCopies = book.getNumberOfCopiesOfBook() + bookQuantity;
            book.setNumberOfCopiesOfBook(totalNumberOfCopies);
            System.out.println(bookQuantity + " more copies of " + book.getTitleOfBook() + " has been added.");

        } else {
            book.setNumberOfCopiesOfBook(bookQuantity);
            listOfBooks.add(book);
            System.out.println(book.getTitleOfBook() + " has been added to the list of books.");

        }
    };

    public static Map<String, String> getMapOfBorrowers() {
        return mapOfBorrowers;
    }

    public static List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public static AddingToBooks getAddingToBooks() {
        return addingToBooks;
    }

    /**
     * Method to get the name and quantity of a book in the library
     *
     * @param book the book object
     * @return the name and quantity of the book
     */
    public String getBookDetails(Book book) {
        if (listOfBooks.contains(book)) {
            return String.format("Book name: %s, Quantity: %d",
                    book.getTitleOfBook(), book.getNumberOfCopiesOfBook());
        } else {
            return book.getTitleOfBook() + " is not in the library.";
        }

    }

    /**
     * Method to get the title and quantity of each book in the library
     */
    public void printBooksInBookList() {
        listOfBooks.forEach(book -> System.out.println("Book Title: " + book.getTitleOfBook()
                + ", Quantity: " + book.getNumberOfCopiesOfBook()));
    }

}


