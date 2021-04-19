package model;


import services.AddingToBooks;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Library {

    static List<Book> listOfBooks = new ArrayList<>();
    static Map<String, String> mapOfBorrowers = new HashMap<>();
    public static Queue<Person> personQueue = new ConcurrentLinkedQueue<>();

    public static Map<String, String> getMapOfBorrowers() {
        return mapOfBorrowers;
    }

    public static List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public static AddingToBooks getAddingToBooks() {
        return addingToBooks;
    }

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
//        public static void addToListOfBooks(Book book, int bookQuantity) {
//
//        }


    public String getBookDetails(Book book) {
        if (listOfBooks.contains(book)) {
            return String.format("Book name: %s, Quantity: %d",
                    book.getTitleOfBook(), book.getNumberOfCopiesOfBook());
        } else {
            return book.getTitleOfBook() + " is not in the library.";
        }

    }


    public void printBooksInBookList() {

        listOfBooks.forEach(book -> System.out.println("Book Title: " + book.getTitleOfBook()
                        + ", Quantity: " + book.getNumberOfCopiesOfBook()));
        }

    }


