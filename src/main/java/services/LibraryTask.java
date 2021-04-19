package services;

import model.Person;

import java.util.PriorityQueue;

@FunctionalInterface
public interface LibraryTask {
    void giveBook();

    //default void giveBook(PriorityQueue<Person> personPriorityQueue) { }
}
