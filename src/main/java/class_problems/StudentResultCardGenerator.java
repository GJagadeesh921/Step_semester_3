
import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void printResult() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(),
                calculateAverage(),
                calculateGrade());
    }
}

public class StudentResultCardGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("Asha", new int[]{80, 90, 70});
        Student s2 = new Student("Ravi", new int[]{60, 55, 50});

        s1.printResult();
        s2.printResult();

        sc.close();
    }
}
