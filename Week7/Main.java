import java.util.Scanner;

// Custom exception for invalid ages
class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

// Base class: Father
class Father {
    protected int age;

    // Constructor for Father class
    public Father(int age) throws WrongAgeException {
        if (age < 0) {
            throw new WrongAgeException("Father's age cannot be negative!");
        }
        this.age = age;
        System.out.println("Father's age is set to: " + this.age);
    }
}

// Derived class: Son
class Son extends Father {
    private int sonAge;

    // Constructor for Son class
    public Son(int fatherAge, int sonAge) throws WrongAgeException {
        super(fatherAge); // Call the constructor of the Father class
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be negative!");
        }
        if (sonAge >= fatherAge) {
            throw new WrongAgeException("Son's age cannot be greater than or equal to Father's age!");
        }
        this.sonAge = sonAge;
        System.out.println("Son's age is set to: " + this.sonAge);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input Father's age
            System.out.print("Enter Father's age: ");
            int fatherAge = scanner.nextInt();

            // Input Son's age
            System.out.print("Enter Son's age: ");
            int sonAge = scanner.nextInt();

            // Create Son object (also initializes Father object)
            Son son = new Son(fatherAge, sonAge);
        } catch (WrongAgeException e) {
            // Handle custom exceptions
            System.out.println("Exception occurred: " + e.getMessage());
        } catch (Exception e) {
            // Handle any other exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}
