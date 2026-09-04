import java.util.*;

public class PalindromeChecker {

    // Approach 1: Iterative
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive
    public static boolean isPalindromeRecursive(String text) {

        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkRecursive(text, left + 1, right - 1);
    }

    // Approach 3: Array Reversal
    public static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {

        String text = "madam";

        System.out.println("Input: " + text);

        System.out.println(
                "Iterative: " + isPalindromeIterative(text)
        );

        System.out.println(
                "Recursive: " + isPalindromeRecursive(text)
        );

        System.out.println(
                "Array Reversal: " + isPalindromeArrayReversal(text)
        );
    }
}
