package SEE;

import CIE.Personal;

public class External extends Personal {
    public int[] seeMarks = new int[5];

    // Constructor
    public External(String usn, String name, int sem) {
        super(usn, name, sem);
    }

    // Method to set SEE marks
    public void setSEEMarks(int[] marks) {
        for (int i = 0; i < 5; i++) {
            seeMarks[i] = marks[i];
        }
    }

    // Method to display SEE marks
    public void displaySEEMarks() {
        System.out.print("SEE Marks: ");
        for (int mark : seeMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
