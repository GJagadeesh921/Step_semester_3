public class MessWallet {

    // Private field
    private double balance;

    // Constructor
    public MessWallet(double openingBalance) {

        if (openingBalance < 0) {
            System.out.println("Warning: Negative opening balance. Starting at 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    // Add money to wallet
    public void topUp(double amount) {

        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
        } else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    // Deduct money from wallet
    public void deduct(double amount) {

        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be positive");
        } else {
            balance -= amount;
        }
    }

    // Read-only access to balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        // Opening balance
        MessWallet wallet = new MessWallet(500);

        // Add money
        wallet.topUp(200);

        // Try to deduct more than available balance
        wallet.deduct(1000);

        // Display final balance
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
