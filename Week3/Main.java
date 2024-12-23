import java.util.Scanner;

class Book {
    // Members of the Book class
    private String name;
    private String author;
    private double price;
    private int num_pages;

    // Constructor to set the values for the members
    public Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    // Method to set details of the book
    public void setDetails(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    // Getters for each member
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getNumPages() {
        return num_pages;
    }

    // Method to display complete details of the book
    @Override
    public String toString() {
        return "Book Details:\n" +
                "Name: " + name + "\n" +
                "Author: " + author + "\n" +
                "Price: $" + price + "\n" +
                "Number of Pages: " + num_pages;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking the user for the number of books
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Creating an array of Book objects
        Book[] books = new Book[n];

        // Accepting details for each book
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();
            
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            
            System.out.print("Enter Number of Pages: ");
            int num_pages = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Initializing the book object using the constructor
            books[i] = new Book(name, author, price, num_pages);
        }

        // Displaying details of all the books
        System.out.println("\n--- Book List ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            System.out.println(books[i].toString());
        }

        scanner.close();
    }
}
