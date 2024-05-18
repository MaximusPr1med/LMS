/**
 * Name: Max Shoemaker
 * Course: CEN 3024C
 * Date: 5/18/2024
 * Class Name: Book
 * This class represents a book with an ID, title, and author.
 * The class is used to store and use the data from the console.
 */
public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return id + ", " + title + ", " + author;
    }
}
