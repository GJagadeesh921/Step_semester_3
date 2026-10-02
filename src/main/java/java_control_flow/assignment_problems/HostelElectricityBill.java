import java.util.Scanner;

abstract class Room {
    protected double units;
    protected int occupants;
    protected boolean ac;

    public Room(double units, int occupants, boolean ac) {
        this.units = units;
        this.occupants = occupants;
        this.ac = ac;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class SingleRoom extends Room {

    public SingleRoom(double units, int occupants, boolean ac) {
        super(units, occupants, ac);
    }

    @Override
    public double calculateBill() {

        double bill = units * 8;

        if (ac) {
            bill += units * 10 + 200;
        }

        return bill;
    }

    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {

    public SharedRoom(double units, int occupants, boolean ac) {
        super(units, occupants, ac);
    }

    @Override
    public double calculateBill() {

        double bill = (units * 6) / occupants;

        if (ac) {
            bill += units * 10 + 200;
        }

        return bill;
    }

    @Override
    public String getType() {
        return "SHARED";
    }
}

public class HostelElectricityBill {

    public static Room createRoom(String type, double units,
                                   int occupants, boolean ac) {

        switch (type) {

            case "SINGLE":
                return new SingleRoom(units, occupants, ac);

            case "SHARED":
                return new SharedRoom(units, occupants, ac);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();
            int occupants = sc.nextInt();
            boolean ac = sc.nextBoolean();

            Room room = createRoom(
                    type,
                    units,
                    occupants,
                    ac
            );

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
