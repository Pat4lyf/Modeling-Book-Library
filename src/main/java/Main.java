import model.Book;
import model.Library;
import model.Person;
import services.LibraryTask;
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


        Library.getAddingToBooks().addToListOfBooks(book1, 5);
        Library.getAddingToBooks().addToListOfBooks(book1, 6);
        Library.getAddingToBooks().addToListOfBooks(book2, 3);
        Library.getAddingToBooks().addToListOfBooks(book3, 2);
        System.out.println(Library.getListOfBooks());


        System.out.println();
        Library library = new Library();
        library.printBooksInBookList();
        System.out.println();

        person.requestForBook(book2);
        person1.requestForBook(book1);
        person4.requestForBook(book3);
        person2.requestForBook(book1);
        person3.requestForBook(book3);
        person5.requestForBook(book1);

        System.out.println(Person.mapOfAllBookRequests);


        System.out.println(Library.personQueue.size());

//        ImplementationUsingQueue implementationUsingQueue = new ImplementationUsingQueue();
//        implementationUsingQueue.getLibraryTask().giveBook();

        System.out.println(Library.getMapOfBorrowers());
        System.out.println(Library.getMapOfBorrowers().size());

        ImplementationUsingPriorityQueue implementationUsingPriorityQueue = new ImplementationUsingPriorityQueue();
        implementationUsingPriorityQueue.giveBookBasedOnPriority();
        System.out.println();
        System.out.println(Library.getMapOfBorrowers());
        System.out.println(Library.getMapOfBorrowers().size());
        System.out.println();
        person2.returnBook();
        System.out.println(Library.getMapOfBorrowers().size());

    }

}

