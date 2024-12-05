public class Main {
   public static void main(String[] args) {
    String[][] data1 = {
        { "Borjigin", "Temüjin", "85", "90", "80", "88", "75", "80", "70", "85", "90", "95", "85", "78", "88", "92" }
    };

    Gradebook testBook1 = new Gradebook(data1);

    // Test changeGrade
    System.out.println(testBook1.changeGrade("Borjigin", "Homework 5", 95)); // true
    System.out.println(testBook1.changeGrade("Borjigin", "Homework 15", 95)); // false

    // Test findAssignmentAverage
    System.out.println(testBook1.findAssignmentAverage("Homework 5")); // 95.0

    // Test findStudentAverage
    System.out.println(testBook1.findStudentAverage("Borjigin")); // Weighted average

    // Test printStudentInfo
    testBook1.printStudentInfo("Borjigin"); // Prints scores
    testBook1.printStudentInfo("Unknown"); // Student not found
}
}