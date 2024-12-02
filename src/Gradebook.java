public class Gradebook {

    String[] labels = { "Last", "First", "Test1", "Test2", "Quiz1", "Quiz2", "Homework1", "Homework2", "Homework3",
            "Homework4", "Homework5", "Homework6", "Homework7", "Homework8", "Homework9", "Homework10" };

    String[][] book;

    public Gradebook(String[][] b) {
        if (b.length > 0 && b[0].length == 16) {
            book = b;
        }

        else {
            System.out.println("Gradebook is not the right size. Ensure that formatting is correct.");
            book = new String[1][16];
        }
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public boolean changeGrade(String lastName, String assnName, int newGrade) {
        int assnIndex = -1;
        for (int i = 0; i < labels.length; i++) {
        if (labels[i].equalsIgnoreCase(assnName)) {
            assnIndex = i;
            break;
        }
    }

    if (assnIndex == -1) {
        return false; // Assignment not found
    }

    // Find the student row
    for (int i = 0; i < book.length; i++) {
        if (book[i][0].equalsIgnoreCase(lastName)) {
            book[i][assnIndex] = String.valueOf(newGrade);
            return true; // Grade successfully changed
        }
    }
        return false;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double findAssignmentAverage(String assnName) {
         int assnIndex = -1;

    // Find the assignment index
    for (int i = 0; i < labels.length; i++) {
        if (labels[i].equalsIgnoreCase(assnName)) {
            assnIndex = i;
            break;
        }
    }

    if (assnIndex == -1) {
        return -1;
    }

    double total = 0;
    int count = 0;

    // Calculate average
    for (int i = 0; i < book.length; i++) {
        total += Double.parseDouble(book[i][assnIndex]);
        count++;
    }

    return total / count;
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public double findStudentAverage(String lastName) {
        for (int i = 0; i < book.length; i++) {
        if (book[i][0].equalsIgnoreCase(lastName)) {
            double testTotal = 0, quizTotal = 0, homeworkTotal = 0;

            testTotal += Double.parseDouble(book[i][1]);
            testTotal += Double.parseDouble(book[i][2]);

            quizTotal += Double.parseDouble(book[i][3]);
            quizTotal += Double.parseDouble(book[i][4]);

            for (int j = 5; j < labels.length; j++) {
                homeworkTotal += Double.parseDouble(book[i][j]);
            }

            double testAvg = testTotal / 2;
            double quizAvg = quizTotal / 2;
            double homeworkAvg = homeworkTotal / 10;

            return 0.3 * testAvg + 0.3 * quizAvg + 0.4 * homeworkAvg;
        }
    }
        return -1;
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void printStudentInfo(String lastName) {
        for (int i = 0; i < book.length; i++) {
        if (book[i][0].equalsIgnoreCase(lastName)) {
            System.out.println("Student: " + book[i][0]);

            for (int j = 1; j < labels.length; j++) {
                System.out.println(labels[j] + ": " + book[i][j]);
            }

            return;
        }
    }

    System.out.println("Student with last name " + lastName + " not found.");
}
    }


