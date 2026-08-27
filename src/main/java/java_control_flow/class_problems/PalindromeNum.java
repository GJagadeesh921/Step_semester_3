package java_control_flow.class_problems;

public class PalindromeNum {
    public static void main(String[] args) {

        int num = 2002;

        int temp = num;
        int rev = 0;

        while (num > 0) {
            int last = num % 10;
            num = num / 10;
            rev = (rev * 10) + last;
        }

        if (rev == temp) {
            System.out.println("The number is a palindrome number");
        } else {
            System.out.println("The number is not a palindrome number");
        }
    }
}