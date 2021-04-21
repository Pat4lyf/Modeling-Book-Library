import model.Book;
import model.Library;
import model.Person;
import servicesimplementation.ImplementationUsingPriorityQueue;
import servicesimplementation.ImplementationUsingQueue;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Bola", "Junior Student");
        Person person1 = new Person("Glory", "Senior Student");
        Person person2 = new Person("Pat", "Teacher");
        Person person3 = new Person("Ruth", "Junior Student");
        Person person4 = new Person("Divine", "Senior Student");
        Person person5 = new Person("Abdul", "Teacher");
        Book book1 = new Book("Sugar Girl", "Bibs Bush");
        Book book2 = new Book("The Orphan Boy", "Alex Jobs");
        Book book3 = new Book("Blooming Flowers", "John Max");
        Book book4 = new Book("Hope Found", "Brown Wells");


        System.out.println();
        Library.getAddingToBooks().addToListOfBooks(book1, 5);
        Library.getAddingToBooks().addToListOfBooks(book1, 6);
        Library.getAddingToBooks().addToListOfBooks(book2, 3);
        Library.getAddingToBooks().addToListOfBooks(book3, 2);

        System.out.println();
        System.out.println("The list of books registered in the library:");
        Library.getListOfBooks().stream().forEach(book -> System.out.println(book));


        System.out.println();
        Library library = new Library();
        System.out.println("The book titles present in the library and each of their quantity:");
        library.printBooksInBookList();
        System.out.println();

        person3.requestForBook(book3);
        person.requestForBook(book2);
        person1.requestForBook(book1);

        person2.requestForBook(book1);
        person4.requestForBook(book3);
        person5.requestForBook(book1);

        System.out.println();
        System.out.println("The list of all book requests: ");
        Person.listOfAllBookRequests.stream().forEach(book -> System.out.println(book));


        System.out.println();
        System.out.println("The number of people in the queue: " + Library.personQueue.size());
        System.out.println("The number of borrowers before giving book: " + Library.getMapOfBorrowers().size());

        System.out.println();
        ImplementationUsingQueue implementationUsingQueue = new ImplementationUsingQueue();
        implementationUsingQueue.getLibraryTask().giveBook();


        ImplementationUsingPriorityQueue implementationUsingPriorityQueue = new ImplementationUsingPriorityQueue();
        implementationUsingPriorityQueue.giveBookBasedOnPriority();
        System.out.println();
        System.out.println("The names of borrowers and the book each of them borrowed:");
        Library.getMapOfBorrowers().entrySet().forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
        System.out.println("The number of borrowers after giving book:" + Library.getMapOfBorrowers().size());
        System.out.println();
        person2.returnBook();

        System.out.println("The number of borrowers after a person returns the borrowed book: " + Library.getMapOfBorrowers().size());

        System.out.println();
        System.out.println(library.getBookDetails(book1));

    }

}

