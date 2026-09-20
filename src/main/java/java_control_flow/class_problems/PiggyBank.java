public class PiggyBank {

    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit rejected: amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
        } else {
            savings -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        System.out.println("Initial savings: " + pb.getSavings());

        pb.deposit(100);
        System.out.println("Savings after deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings after withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Savings after rejected withdrawal: "
                + pb.getSavings());
    }
}
