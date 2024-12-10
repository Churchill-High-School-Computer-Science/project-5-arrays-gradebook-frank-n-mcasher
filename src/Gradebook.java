public class Gradebook {

    String[] labels = { "Last", "First", "Test1", "Test2", "Quiz1", "Quiz2", "Homework1", "Homework2", "Homework3",
            "Homework4", "Homework5", "Homework6", "Homework7", "Homework8", "Homework9", "Homework10" };

    String[][] book;

    public Gradebook(String[][] b) {
        if (b.length > 0 && b[0].length == 16) {
            book = b;
        } else {
            System.out.println("Gradebook is not the right size. Ensure that formatting is correct.");
            book = new String[1][16];
        }
    }

    // changeGrade() method
    public boolean changeGrade(String lastName, String assnName, int newGrade) {
        int studentIndex = -1;
        int assnIndex = -1;

        // Find the student index
        for (int i = 0; i < book.length; i++) {
            if (book[i][0].equals(lastName)) {
                studentIndex = i;
                break;
            }
        }

        // Find the assignment index
        for (int i = 0; i < labels.length; i++) {
            if (labels[i].equals(assnName)) {
                assnIndex = i;
                break;
            }
        }

        if (studentIndex != -1 && assnIndex != -1) {
            // Update the grade if both student and assignment are found
            book[studentIndex][assnIndex] = String.valueOf(newGrade);
            return true;
        }

        return false; // If either the student or the assignment is not found
    }

    // findAssignmentAverage() method
    public double findAssignmentAverage(String assnName) {
        int assnIndex = -1;

        // Find the assignment index
        for (int i = 0; i < labels.length; i++) {
            if (labels[i].equals(assnName)) {
                assnIndex = i;
                break;
            }
        }

        if (assnIndex == -1) {
            return -1; // Return -1 if the assignment doesn't exist
        }

        double total = 0;
        int count = 0;

        // Calculate the sum of all student scores for the assignment
        for (int i = 0; i < book.length; i++) {
            total += Double.parseDouble(book[i][assnIndex]);
            count++;
        }

        return total / count; // Return the average
    }

    // findStudentAverage() method
    public double findStudentAverage(String lastName) {
        int studentIndex = -1;

        // Find the student index
        for (int i = 0; i < book.length; i++) {
            if (book[i][0].equals(lastName)) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex == -1) {
            return -1; // Return -1 if the student doesn't exist
        }

        // Calculate weighted averages
        double testAvg = (Double.parseDouble(book[studentIndex][2]) + Double.parseDouble(book[studentIndex][3])) / 2.0;
        double quizAvg = (Double.parseDouble(book[studentIndex][4]) + Double.parseDouble(book[studentIndex][5])) / 2.0;
        double homeworkAvg = 0;

        for (int i = 6; i <= 15; i++) {
            homeworkAvg += Double.parseDouble(book[studentIndex][i]);
        }
        homeworkAvg /= 10.0;

        // Calculate weighted grade point average
        return (testAvg * 0.30) + (quizAvg * 0.30) + (homeworkAvg * 0.40);
    }

    // printStudentInfo() method
    public void printStudentInfo(String lastName) {
        int studentIndex = -1;

        // Find the student index
        for (int i = 0; i < book.length; i++) {
            if (book[i][0].equals(lastName)) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex == -1) {
            System.out.println("Student " + lastName + " does not exist.");
            return;
        }

        // Print the student's info
        System.out.println("Student: " + book[studentIndex][1] + " " + book[studentIndex][0]);
        for (int i = 2; i < labels.length; i++) {
            System.out.println(labels[i] + ": " + book[studentIndex][i]);
        }
    }
}


