import java.util.Scanner;

abstract class Employee {
    protected double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public abstract String getType();
}

class FullTime extends Employee {

    public FullTime(double salary) {
        super(salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10;
    }

    @Override
    public String getType() {
        return "FULL-TIME";
    }
}

class PartTime extends Employee {

    public PartTime(double salary) {
        super(salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.05;
    }

    @Override
    public String getType() {
        return "PART-TIME";
    }
}

class Intern extends Employee {

    public Intern(double salary) {
        super(salary);
    }

    @Override
    public double calculateBonus() {
        return 2000;
    }

    @Override
    public String getType() {
        return "INTERN";
    }
}

public class FestivalBonusCalculator {

    public static Employee createEmployee(String type, double salary) {

        switch (type) {

            case "FULL-TIME":
                return new FullTime(salary);

            case "PART-TIME":
                return new PartTime(salary);

            case "INTERN":
                return new Intern(salary);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double salary = sc.nextDouble();

            Employee employee =
                    createEmployee(type, salary);

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n",
                    employee.getType(), bonus);

            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n",
                totalBonus);

        sc.close();
    }
}
