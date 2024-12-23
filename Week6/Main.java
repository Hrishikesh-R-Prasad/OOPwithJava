import CIE.*;
import SEE.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // Create arrays for objects
        External[] students = new External[n];
        Internals[] internals = new Internals[n];

        // Input details for each student
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1) + ":");

            // Input personal details
            System.out.print("Enter USN: ");
            String usn = scanner.next();
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Semester: ");
            int sem = scanner.nextInt();

            // Create objects
            students[i] = new External(usn, name, sem);
            internals[i] = new Internals();

            // Input internal marks
            System.out.println("Enter 5 internal marks: ");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                internalMarks[j] = scanner.nextInt();
            }
            internals[i].setInternalMarks(internalMarks);

            // Input SEE marks
            System.out.println("Enter 5 SEE marks: ");
            int[] seeMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = scanner.nextInt();
            }
            students[i].setSEEMarks(seeMarks);
        }

        // Display details and calculate final marks
        System.out.println("\nFinal Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            students[i].displayPersonalDetails();
            internals[i].displayInternalMarks();
            students[i].displaySEEMarks();

            System.out.print("Final Marks: ");
            for (int j = 0; j < 5; j++) {
                int finalMarks = internals[i].internalMarks[j] + (students[i].seeMarks[j] / 2);
                System.out.print(finalMarks + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
