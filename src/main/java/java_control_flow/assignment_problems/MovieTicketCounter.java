import java.util.Scanner;

abstract class Ticket {
    protected int count;

    private static final double CONVENIENCE_FEE = 20.0;

    public Ticket(int count) {
        this.count = count;
    }

    public abstract double getPricePerTicket();

    public abstract String getType();

    public double calculateAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {

    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 150.0;
    }

    @Override
    public String getType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {

    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 250.0;
    }

    @Override
    public String getType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {

    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() {
        return 400.0;
    }

    @Override
    public String getType() {
        return "RECLINER";
    }
}

public class MovieTicketCounter {

    public static Ticket createTicket(String type, int count) {

        switch (type) {
            case "REGULAR":
                return new RegularTicket(count);

            case "PREMIUM":
                return new PremiumTicket(count);

            case "RECLINER":
                return new ReclinerTicket(count);

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
            int count = sc.nextInt();

            Ticket ticket = createTicket(type, count);

            double amount = ticket.calculateAmount();

            System.out.printf(
                    "%s: %.2f%n",
                    ticket.getType(),
                    amount
            );

            total += amount;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}
