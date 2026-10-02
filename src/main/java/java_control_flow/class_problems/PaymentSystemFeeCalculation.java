import java.util.Scanner;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFee();

    public abstract String getType();
}

class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.02;
    }

    @Override
    public String getType() {
        return "CARD";
    }
}

class WalletPayment extends Payment {

    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.01;
    }

    @Override
    public String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {

    public BankTransfer(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return 0;
    }

    @Override
    public String getType() {
        return "BANK_TRANSFER";
    }
}

public class PaymentSystemFeeCalculation {

    public static Payment createPayment(
            String type, double amount) {

        switch (type) {

            case "CARD":
                return new CardPayment(amount);

            case "WALLET":
                return new WalletPayment(amount);

            case "BANK_TRANSFER":
                return new BankTransfer(amount);

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
            double amount = sc.nextDouble();

            Payment payment =
                    createPayment(type, amount);

            double fee =
                    payment.calculateFee();

            System.out.printf(
                    "%s: %.2f%n",
                    payment.getType(),
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
