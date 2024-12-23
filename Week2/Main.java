import java.util.Scanner;

class Student {

    private String usn;
    private String name;
    private int[] credits;
    private int[] marks;
    private int numSubjects;


    public void acceptDetails() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter USN: ");
        usn = scanner.nextLine();
        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        numSubjects = scanner.nextInt();

 
        credits = new int[numSubjects];
        marks = new int[numSubjects];

  
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = scanner.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }


    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Number of Subjects: " + numSubjects);

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": Credits = " + credits[i] + ", Marks = " + marks[i]);
        }
    }


    public double calculateSGPA() {
        int totalCredits = 0;
        int totalGradePoints = 0;

        for (int i = 0; i < numSubjects; i++) {
            int gradePoint = getGradePoint(marks[i]);
            totalGradePoints += gradePoint * credits[i];
            totalCredits += credits[i];
        }

   
        if (totalCredits > 0) {
            return (double) totalGradePoints / totalCredits;
        } else {
            return 0.0;
        }
    }


    private int getGradePoint(int marks) {
        if (marks >= 90) return 10;
        else if (marks >= 80) return 9;
        else if (marks >= 70) return 8;
        else if (marks >= 60) return 7;
        else if (marks >= 50) return 6;
        else if (marks >= 40) return 5;
        else return 0; 
    }
}

public class Main {
    public static void main(String[] args) {
    
        Student student = new Student();

  
        student.acceptDetails();
        student.displayDetails();

      
        double sgpa = student.calculateSGPA();
        System.out.println("\nSGPA: " + sgpa);
    }
}
