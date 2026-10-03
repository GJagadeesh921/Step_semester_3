import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;

    private static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public abstract String getType();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {

    public BusBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 2.0;
    }

    @Override
    public String getType() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {

    public TrainBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 1.5;
    }

    @Override
    public String getType() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {

    public FlightBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distance * 4.0);
    }

    @Override
    public String getType() {
        return "FLIGHT";
    }
}

public class TravelBookingCommonFee {

    public static TravelBooking createBooking(
            String type,
            double distance) {

        switch (type) {

            case "BUS":
                return new BusBooking(distance);

            case "TRAIN":
                return new TrainBooking(distance);

            case "FLIGHT":
                return new FlightBooking(distance);

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

            TravelBooking booking =
                    createBooking(type, distance);

            double fare = booking.calculateTotalFare();

            System.out.printf(
                    "%s: %.2f%n",
                    booking.getType(),
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
