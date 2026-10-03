import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }

        double regularPay = 40 * rate;
        double overtimeHours = hours - 40;
        double overtimePay = overtimeHours * rate * 1.5;

        return regularPay + overtimePay;
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    public static Staff createStaff(
            String type,
            String name,
            Scanner sc) {

        switch (type) {

            case "FULLTIME":
                double weeklySalary = sc.nextDouble();
                return new FullTimeStaff(name, weeklySalary);

            case "HOURLY":
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                return new HourlyStaff(name, hours, rate);

            case "INTERN":
                double stipend = sc.nextDouble();
                return new InternStaff(name, stipend);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalPay = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Staff staff = createStaff(type, name, sc);

            double pay = staff.calculatePay();

            System.out.printf(
                    "%s: %.2f%n",
                    staff.getName(),
                    pay
            );

            totalPay += pay;
        }

        System.out.printf(
                "Total Pay: %.2f%n",
                totalPay
        );

        sc.close();
    }
}
