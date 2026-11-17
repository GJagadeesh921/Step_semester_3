
import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
}

class CashPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

class CardPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount + (amount * 0.02);
    }
}

class UpiPayment implements PaymentMode {
    public double processPayment(double amount) {
        return amount;
    }
}

public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            amounts[i] = sc.nextDouble();

            if (mode.equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment();
            }
            else if (mode.equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment();
            }
            else {
                payments[i] = new UpiPayment();
            }
        }

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            double amount = amounts[i];
            double processed = payments[i].processPayment(amount);
            double fee = processed - amount;

            String mode;

            if (payments[i] instanceof CashPayment) {
                mode = "Cash";
            }
            else if (payments[i] instanceof CardPayment) {
                mode = "Card";
            }
            else {
                mode = "UPI";
            }

            System.out.println(mode + ": amount " +
                amount + ", fee " + fee +
                ", processed " + processed);

            grandTotal += processed;
        }

        System.out.println("Total Amount Processed: " + grandTotal);

        sc.close();
    }
}
