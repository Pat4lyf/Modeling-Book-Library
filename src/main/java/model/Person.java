package model;

import java.util.HashMap;

import java.util.Map;

public class Person implements Comparable<Person> {
    private String nameOfPerson;
    private String roleOfPerson;
    private int levelOfPerson;
    private Book bookRequestOfPerson = null;
    public static Map<Book, Integer> mapOfAllBookRequests = new HashMap();


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


//    public int getNumberOfRequestsForBook() {
//        return numberOfRequestsForBook;
//    }

    public void requestForBook(Book book) {
        this.bookRequestOfPerson = book;
        Library.personQueue.add(this);
       int numberOfRequestsForBook = 1;

        if (mapOfAllBookRequests.containsKey(book)) {
            numberOfRequestsForBook = mapOfAllBookRequests.get(book) + 1;
        }
        //ADDING THE BOOK AND THE BOOK QUANTITY TO THE MAP OF ALL BOOK REQUESTS
         mapOfAllBookRequests.put(book,numberOfRequestsForBook);

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

    @Override
    public int compareTo(Person person) {
        if (this.levelOfPerson >= person.levelOfPerson){
            return 1;
        }
        else {return -1;}
    }

    public void returnBook() {
        if (Library.mapOfBorrowers.containsKey(this.nameOfPerson)) {
            if (Library.listOfBooks.contains(this.getBookRequestOfPerson())) {
                int finalNumberOfCopiesOfBook = this.getBookRequestOfPerson().getNumberOfCopiesOfBook() + 1;
                this.getBookRequestOfPerson().setNumberOfCopiesOfBook(finalNumberOfCopiesOfBook);

                System.out.println(this.nameOfPerson + " has returned " + this.getBookRequestOfPerson().getTitleOfBook() + " to the library.");
                Library.mapOfBorrowers.remove(this.nameOfPerson, this.getBookRequestOfPerson().getTitleOfBook());
            } else {
                System.out.println("This book is not from this library");
            }
        }
        else {
            System.out.println("Your name is not in the list of borrowers.");
        }
    }
}
