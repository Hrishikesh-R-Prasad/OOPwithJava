import java.util.Scanner;

// Abstract class Shape
abstract class Shape {
    int dimension1;
    int dimension2;

    // Abstract method to print the area
    abstract void printArea();
}

// Rectangle class extending Shape
class Rectangle extends Shape {
    // Constructor to initialize dimensions
    Rectangle(int length, int breadth) {
        this.dimension1 = length;
        this.dimension2 = breadth;
    }

    // Method to print the area of the rectangle
    @Override
    void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}

// Triangle class extending Shape
class Triangle extends Shape {
    // Constructor to initialize base and height
    Triangle(int base, int height) {
        this.dimension1 = base;
        this.dimension2 = height;
    }

    // Method to print the area of the triangle
    @Override
    void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}

// Circle class extending Shape
class Circle extends Shape {
    // Constructor to initialize radius
    Circle(int radius) {
        this.dimension1 = radius;
    }

    // Method to print the area of the circle
    @Override
    void printArea() {
        double area = Math.PI * dimension1 * dimension1;
        System.out.println("Area of Circle: " + area);
    }
}

// Main class to test the program
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Rectangle input and area calculation
        System.out.print("Enter the length of the Rectangle: ");
        int length = scanner.nextInt();
        System.out.print("Enter the breadth of the Rectangle: ");
        int breadth = scanner.nextInt();
        Rectangle rectangle = new Rectangle(length, breadth);
        rectangle.printArea();

        // Triangle input and area calculation
        System.out.print("\nEnter the base of the Triangle: ");
        int base = scanner.nextInt();
        System.out.print("Enter the height of the Triangle: ");
        int height = scanner.nextInt();
        Triangle triangle = new Triangle(base, height);
        triangle.printArea();

        // Circle input and area calculation
        System.out.print("\nEnter the radius of the Circle: ");
        int radius = scanner.nextInt();
        Circle circle = new Circle(radius);
        circle.printArea();

        scanner.close();
    }
}
