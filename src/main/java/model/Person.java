package model;

import java.util.ArrayList;
import java.util.List;


public class Person implements Comparable<Person> {

    /**
     * defining the fields of the Person class
     */
    private String nameOfPerson;
    private String roleOfPerson;
    private int levelOfPerson;
    private Book bookRequestOfPerson = null;
    public static List<Book> listOfAllBookRequests = new ArrayList<>();


    /**
     * A constructor
     *
     * @param nameOfPerson the name of the person
     * @param roleOfPerson the role of the person
     */
    public Person(String nameOfPerson, String roleOfPerson) {
        this.nameOfPerson = nameOfPerson;
        this.roleOfPerson = roleOfPerson;
        assignLevelToPerson();
    }


    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    public String getRoleOfPerson() {
        return roleOfPerson;
    }

    public void setRoleOfPerson(String roleOfPerson) {
        this.roleOfPerson = roleOfPerson;
    }

    public int getLevelOfPerson() {
        return levelOfPerson;
    }

    public Book getBookRequestOfPerson() {
        return bookRequestOfPerson;
    }

    /**
     * Method to assign level to a person based on the role of that person
     */
    private void assignLevelToPerson() {
        if (this.roleOfPerson.equalsIgnoreCase("Teacher")) {
            levelOfPerson = 1;
        } else if (this.roleOfPerson.equalsIgnoreCase("Senior Student")) {
            levelOfPerson = 2;
        } else if (this.roleOfPerson.equalsIgnoreCase("Junior Student")) {
            levelOfPerson = 3;
        } else {
            System.out.println("No such role found");
        }
    }

    /**
     * Method to request for a book
     *
     * @param book the book requested for
     */
    public void requestForBook(Book book) {
        this.bookRequestOfPerson = book;

        //ADDING THE PERSON TO THE QUEUE
        if (!Library.personQueue.contains(this) && this != null) {
            Library.personQueue.add(this);
        } else {
            System.out.println("You are already in the queue");
        }
        //ADDING THE BOOK TO THE LIST OF ALL BOOK REQUESTS
        if (!listOfAllBookRequests.contains(book)) {
            listOfAllBookRequests.add(book);
        }


        if (Library.personQueue.size() < 3) {
            System.out.println("Hello, " + this.nameOfPerson + " you have been added to the queue, but we need "
                    + (3 - Library.personQueue.size()) + " more people before processing requests.");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "nameOfPerson='" + nameOfPerson + '\'' +
                ", roleOfPerson='" + roleOfPerson + '\'' +
                ", levelOfPerson=" + levelOfPerson +
                ", bookRequestOfPerson='" + bookRequestOfPerson.getTitleOfBook() + '\'' +
                '}';
    }

    /**
     * Implementing a comparable
     *
     * @param person a person object
     * @return the value
     */
    @Override
    public int compareTo(Person person) {
        if (this.levelOfPerson >= person.levelOfPerson) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Method to return a book to the library
     */
    public void returnBook() {
        if (Library.mapOfBorrowers.containsKey(this.nameOfPerson)) {
            try {
                Library.listOfBooks.stream().filter(book -> book.equals(this.getBookRequestOfPerson())).forEach(person -> {
                    int finalNumberOfCopiesOfBook = this.getBookRequestOfPerson().getNumberOfCopiesOfBook() + 1;
                    this.getBookRequestOfPerson().setNumberOfCopiesOfBook(finalNumberOfCopiesOfBook);

                    System.out.println(this.nameOfPerson + " has returned " + this.getBookRequestOfPerson().getTitleOfBook() + " to the library.");
                    Library.mapOfBorrowers.remove(this.nameOfPerson, this.getBookRequestOfPerson().getTitleOfBook());

                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("Your name is not in the list of borrowers.");
        }
    }
}
