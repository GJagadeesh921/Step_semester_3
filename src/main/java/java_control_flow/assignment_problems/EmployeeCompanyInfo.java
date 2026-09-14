class Employee {

    // Instance fields
    String empName;
    double salary;

    // Static fields
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        // Increment count whenever an object is created
        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyInfo {

    public static void main(String[] args) {

        // Create three Employee objects
        Employee employee1 = new Employee("Ravi", 45000);
        Employee employee2 = new Employee("Anitha", 55000);
        Employee employee3 = new Employee("Karthik", 50000);

        System.out.println("3 Employee objects created");

        // Call static method using class name
        Employee.printCompanyInfo();
    }
}
