
import java.util.Scanner;
import java.util.Arrays;

public class DiceThrowTally {

    static int[] diceSort(int[] rolls) {

        int[] count = new int[7];

        // Count frequency of each dice result
        for (int i = 0; i < rolls.length; i++) {
            count[rolls[i]]++;
        }

        // Print frequencies
        System.out.print("Counts: ");

        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + count[i] + " ");
        }

        System.out.println();

        // Create sorted result array
        int[] result = new int[rolls.length];

        int index = 0;

        // Build sorted array using frequencies
        for (int i = 1; i <= 6; i++) {

            for (int j = 0; j < count[i]; j++) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rolls: ");
        int n = sc.nextInt();

        int[] rolls = new int[n];

        System.out.println("Enter dice results (1 to 6):");

        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }

        int[] sorted = diceSort(rolls);

        System.out.println("Sorted: " + Arrays.toString(sorted));

        sc.close();
    }
}
