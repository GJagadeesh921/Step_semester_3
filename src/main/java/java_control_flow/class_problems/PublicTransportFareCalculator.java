import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public abstract String getType();
}

class Bus extends Transport {

    public Bus(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2 + (0.10 * distance);

        if (fare > 10) {
            fare = 10;
        }

        return fare;
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class Train extends Transport {

    public Train(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakFactor;

    public Metro(double distance, double peakFactor) {
        super(distance);
        this.peakFactor = peakFactor;
    }

    @Override
    public double calculateFare() {
        return 1.50 + (0.20 * distance * peakFactor);
    }

    @Override
    public String getType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {

    public static Transport createTransport(
            String type,
            double distance,
            double peakFactor) {

        switch (type) {

            case "BUS":
                return new Bus(distance);

            case "TRAIN":
                return new Train(distance);

            case "METRO":
                return new Metro(distance, peakFactor);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalFare = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();
            double peakFactor = sc.nextDouble();

            Transport transport = createTransport(
                    type,
                    distance,
                    peakFactor
            );

            double fare = transport.calculateFare();

            System.out.printf(
                    "%s: %.2f%n",
                    transport.getType(),
                    fare
            );

            totalFare += fare;
        }

        System.out.printf(
                "Total Fare: %.2f%n",
                totalFare
        );

        sc.close();
    }
}
