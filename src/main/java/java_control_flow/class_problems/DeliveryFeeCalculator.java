import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();

    public abstract String getType();
}

class StandardDelivery extends Delivery {

    public StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class ExpressDelivery extends Delivery {

    public ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() {
        return "EXPRESS";
    }
}

class InternationalDelivery extends Delivery {
    private double customs;

    public InternationalDelivery(
            double weight,
            double distance,
            double customs) {

        super(weight, distance);
        this.customs = customs;
    }

    @Override
    public double calculateFee() {
        return 25
                + (2.00 * weight)
                + (0.50 * distance)
                + customs;
    }

    @Override
    public String getType() {
        return "INTERNATIONAL";
    }
}

public class DeliveryFeeCalculator {

    public static Delivery createDelivery(
            String type,
            double weight,
            double distance,
            double customs) {

        switch (type) {

            case "STANDARD":
                return new StandardDelivery(weight, distance);

            case "EXPRESS":
                return new ExpressDelivery(weight, distance);

            case "INTERNATIONAL":
                return new InternationalDelivery(
                        weight, distance, customs);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalFee = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customs = sc.nextDouble();

            Delivery delivery = createDelivery(
                    type,
                    weight,
                    distance,
                    customs
            );

            double fee = delivery.calculateFee();

            System.out.printf(
                    "%s: %.2f%n",
                    delivery.getType(),
                    fee
            );

            totalFee += fee;
        }

        System.out.printf(
                "Total Fee: %.2f%n",
                totalFee
        );

        sc.close();
    }
}
