package model;

public class Book {
    private String titleOfBook;
    private String authorOfBook;
    private int numberOfCopiesOfBook = 0;

    public Book(String titleOfBook, String authorOfBook) {
        this.titleOfBook = titleOfBook;
        this.authorOfBook = authorOfBook;
    }

    public String getTitleOfBook() {
        return titleOfBook;

    }


    public void setTitleOfBook(String titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public String getAuthorOfBook() {
        return authorOfBook;
    }

    public void setAuthorOfBook(String authorOfBook) {
        this.authorOfBook = authorOfBook;
    }

    public int getNumberOfCopiesOfBook() {
        return numberOfCopiesOfBook;
    }

    public void setNumberOfCopiesOfBook(int numberOfCopiesOfBook) {
        this.numberOfCopiesOfBook = numberOfCopiesOfBook;

    }

    @Override
    public String toString() {
        return "Book{" +
                "titleOfBook='" + titleOfBook + '\'' +
                ", authorOfBook='" + authorOfBook + '\'' +
                ", numberOfCopiesOfBook=" + numberOfCopiesOfBook +
                '}';
    }
}
