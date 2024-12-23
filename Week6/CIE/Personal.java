package CIE;

public class Personal {
    public String usn;
    public String name;
    public int sem;

    // Constructor
    public Personal(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }

    // Method to display personal details
    public void displayPersonalDetails() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + sem);
    }
}