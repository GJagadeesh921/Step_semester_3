import java.util.Scanner;

abstract class Cab {
    protected double distance;

    public Cab(double distance) {
        this.distance = distance;
    }

    public abstract double getRate();

    public abstract String getType();

    public abstract boolean supportsNightService();

    public double calculateFare() {

        double fare = distance * getRate();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }

    public double calculateNightFare() {
        return calculateFare() * 1.20;
    }
}

class MiniCab extends Cab {

    public MiniCab(double distance) {
        super(distance);
    }

    @Override
    public double getRate() {
        return 10.0;
    }

    @Override
    public String getType() {
        return "MINI";
    }

    @Override
    public boolean supportsNightService() {
        return false;
    }
}

class SedanCab extends Cab {

    public SedanCab(double distance) {
        super(distance);
    }

    @Override
    public double getRate() {
        return 14.0;
    }

    @Override
    public String getType() {
        return "SEDAN";
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab {

    public SUVCab(double distance) {
        super(distance);
    }

    @Override
    public double getRate() {
        return 18.0;
    }

    @Override
    public String getType() {
        return "SUV";
    }

    @Override
    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFareMeter {

    public static Cab createCab(
            String type,
            double distance) {

        switch (type) {

            case "MINI":
                return new MiniCab(distance);

            case "SEDAN":
                return new SedanCab(distance);

            case "SUV":
                return new SUVCab(distance);

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
            double distance = sc.nextDouble();
            String time = sc.next();

            Cab cab = createCab(type, distance);

            if (time.equals("NIGHT")
                    && !cab.supportsNightService()) {

                System.out.printf(
                        "%s: night service not available%n",
                        cab.getType()
                );

                continue;
            }

            double fare;

            if (time.equals("NIGHT")) {
                fare = cab.calculateNightFare();
            } else {
                fare = cab.calculateFare();
            }

            System.out.printf(
                    "%s: %.2f%n",
                    cab.getType(),
                    fare
            );

            total += fare;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
