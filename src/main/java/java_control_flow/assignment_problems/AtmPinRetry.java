package java_control_flow.assignment_problems;

public class AtmPinRetry {

    public static void atmPinRetry(String correctPin, String[] attempts) {

        int attempt = 0;
        boolean success = false;

        while (attempt < attempts.length && attempt < 3 && !success) {

            if (attempts[attempt].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            attempt++;
        }

        if (!success) {
            System.out.println("Card blocked — too many incorrect attempts");
        }
    }

    public static void main(String[] args) {
        String[] attempts = {"1111", "4821"};
        atmPinRetry("4821", attempts);
    }
}