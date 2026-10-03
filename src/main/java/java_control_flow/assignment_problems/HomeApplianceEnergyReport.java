import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPower();

    public abstract String getType();

    public abstract boolean supportsSaverMode();

    public double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0;
    }

    public double calculateSaverUnits() {
        return calculateUnits() * 0.75;
    }

    public double calculateSaverCost() {
        return calculateSaverUnits() * 8.0;
    }
}

class Fridge extends Appliance {

    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 150.0;
    }

    @Override
    public String getType() {
        return "FRIDGE";
    }

    @Override
    public boolean supportsSaverMode() {
        return false;
    }
}

class AC extends Appliance {

    public AC(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 1500.0;
    }

    @Override
    public String getType() {
        return "AC";
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

class TV extends Appliance {

    public TV(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 100.0;
    }

    @Override
    public String getType() {
        return "TV";
    }

    @Override
    public boolean supportsSaverMode() {
        return false;
    }
}

class Washer extends Appliance {

    public Washer(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 500.0;
    }

    @Override
    public String getType() {
        return "WASHER";
    }

    @Override
    public boolean supportsSaverMode() {
        return true;
    }
}

public class HomeApplianceEnergyReport {

    public static Appliance createAppliance(
            String type,
            double hours) {

        switch (type) {

            case "FRIDGE":
                return new Fridge(hours);

            case "AC":
                return new AC(hours);

            case "TV":
                return new TV(hours);

            case "WASHER":
                return new Washer(hours);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            String mode = "NORMAL";

            if (sc.hasNext()) {
                mode = sc.next();
            }

            Appliance appliance =
                    createAppliance(type, hours);

            if (mode.equals("SAVER")
                    && !appliance.supportsSaverMode()) {

                System.out.printf(
                        "%s: saver mode not supported%n",
                        appliance.getType()
                );

                continue;
            }

            double units;
            double cost;

            if (mode.equals("SAVER")) {
                units = appliance.calculateSaverUnits();
                cost = appliance.calculateSaverCost();
            } else {
                units = appliance.calculateUnits();
                cost = appliance.calculateCost();
            }

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(),
                    units,
                    cost
            );

            totalCost += cost;
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                totalCost
        );

        sc.close();
    }
}
