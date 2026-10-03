import java.util.Scanner;

abstract class ElectricityConnection {
    protected double units;

    public ElectricityConnection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {

    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }

        return (100 * 5.0) + ((units - 100) * 7.0);
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends ElectricityConnection {

    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends ElectricityConnection {

    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;

        if (bill < 1000) {
            bill = 1000;
        }

        return bill;
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {

    public static ElectricityConnection createConnection(
            String type,
            double units) {

        switch (type) {

            case "HOME":
                return new HomeConnection(units);

            case "SHOP":
                return new ShopConnection(units);

            case "FACTORY":
                return new FactoryConnection(units);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalBill = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            ElectricityConnection connection =
                    createConnection(type, units);

            double bill = connection.calculateBill();

            System.out.printf(
                    "%s: %.2f%n",
                    connection.getType(),
                    bill
            );

            totalBill += bill;
        }

        System.out.printf(
                "Total Bill: %.2f%n",
                totalBill
        );

        sc.close();
    }
}
