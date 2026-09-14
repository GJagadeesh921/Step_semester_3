public class Student {

    // Instance fields
    String name;
    double attendance;

    // Static fields
    static String collegeName =
        "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        // Increment count whenever a Student object is created
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        // Create two Student objects
        Student student1 =
            new Student("Ravi", 85.5);

        Student student2 =
            new Student("Anitha", 90.0);

        System.out.println("2 Student objects created");

        // Call static method using class name
        Student.printCollegeInfo();
    }
}
