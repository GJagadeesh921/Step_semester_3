
import java.util.Scanner;

public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.print(reversed + " - ");

        if (word.equals(reversed)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }

        sc.close();
    }
}
