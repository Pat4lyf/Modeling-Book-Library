package services;

import model.Book;

@FunctionalInterface
public interface AddingToBooks {
    void addToListOfBooks(Book book, int bookQuantity);
}
