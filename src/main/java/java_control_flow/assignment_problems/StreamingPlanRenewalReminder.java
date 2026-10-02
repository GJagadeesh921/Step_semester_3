import java.time.LocalDate;
import java.util.Scanner;

abstract class StreamingPlan {
    protected LocalDate startDate;

    public StreamingPlan(LocalDate startDate) {
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public abstract String getType();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends StreamingPlan {

    public BasicPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    public int getValidityDays() {
        return 30;
    }

    @Override
    public String getType() {
        return "BASIC";
    }
}

class StandardPlan extends StreamingPlan {

    public StandardPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    public int getValidityDays() {
        return 90;
    }

    @Override
    public String getType() {
        return "STANDARD";
    }
}

class PremiumPlan extends StreamingPlan {

    public PremiumPlan(LocalDate startDate) {
        super(startDate);
    }

    @Override
    public int getValidityDays() {
        return 365;
    }

    @Override
    public String getType() {
        return "PREMIUM";
    }
}

public class StreamingPlanRenewalReminder {

    public static StreamingPlan createPlan(
            String type, LocalDate startDate) {

        switch (type) {

            case "BASIC":
                return new BasicPlan(startDate);

            case "STANDARD":
                return new StandardPlan(startDate);

            case "PREMIUM":
                return new PremiumPlan(startDate);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String date = sc.next();

            LocalDate startDate =
                    LocalDate.parse(date);

            StreamingPlan plan =
                    createPlan(type, startDate);

            LocalDate renewalDate =
                    plan.calculateRenewalDate();

            System.out.printf(
                    "%s: %s%n",
                    plan.getType(),
                    renewalDate
            );
        }

        sc.close();
    }
}
