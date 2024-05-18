import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Name: Max Shoemaker
 * Course: CEN 3024C
 * Date: 5/18/2024
 * Class Name: Book
 * This class manages the library of books, allowing the user to add, remove, list, and sort books.
 */
public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Method: addBooksFromFile
     * Adds books from a specified file that the user inputs.
     */
    public void addBooksFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String title = parts[1].trim();
                    String author = parts[2].trim();
                    books.add(new Book(id, title, author));
                }
            }
            System.out.println("Books added from " + filePath);
            sortBooks();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    /**
     * Method: addBook
     * Adds a book with the ID, Title and Author.
     */
    public void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        sortBooks();
        System.out.println("Book added: ID = " + id + ", Title = " + title + ", Author = " + author);
    }

    /**
     * Method: removeBookbyId
     * Removes a book from the library with the following ID inputted.
     */
    public void removeBookById(int bookId) {
        boolean removed = books.removeIf(book -> book.getId() == bookId);
        if (removed) {
            System.out.println("Book with ID " + bookId + " removed.");
        } else {
            System.out.println("No book found with ID " + bookId + ".");
        }
    }

    /**
     * Method: listBooks
     * Lists all the books in the library.
     */
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.forEach(book -> System.out.println(book));
        }
    }

    /**
    * Method: sortBooks
    * Sorts the list of books by their ID
    */
    private void sortBooks() {
        Collections.sort(books, Comparator.comparingInt(Book::getId));
    }
}
