package java_control_flow.assignment_problems;

public class SumOfNumbers {

    public static void sumNumbersUpToN(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        sumNumbersUpToN(5);
    }
}