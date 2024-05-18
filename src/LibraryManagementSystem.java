import java.util.Scanner;
/**
 * Name: Max Shoemaker
 * Course: CEN 3024C
 * Date: 5/18/2024
 * Class Name: LibraryManagementSystem
 * This class contains the main method which serves as the console for the library management system program.
 * It provides a user interface for managing the books.
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add books from file");
            System.out.println("2. Add a book");
            System.out.println("3. Remove a book");
            System.out.println("4. List books");
            System.out.println("5. Exit");
            System.out.print("Enter: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the file path: ");
                    String filePath = scanner.nextLine();
                    library.addBooksFromFile(filePath);
                    break;
                case 2:
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(id, title, author);
                    break;
                case 3:
                    System.out.print("Enter book ID to remove: ");
                    int bookId = scanner.nextInt();
                    library.removeBookById(bookId);
                    break;
                case 4:
                    System.out.println("All books in the library: ");
                    library.listBooks();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Not an option!");
            }
        }

        scanner.close();
    }
}
