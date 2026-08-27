package java_control_flow.class_problems;

public class PrimeNum {
    public static void main(String[] args) {
        int num = 7;
        boolean isPrime = true;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime == true) {
            System.out.println(num + " is a prime number");
        } else {
            System.out.println(num + " The number is not a prime number");
        }
    }
}