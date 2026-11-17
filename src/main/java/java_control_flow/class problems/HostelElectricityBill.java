
import java.util.Scanner;

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int roomsBilled = 0;
        long grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String room = sc.next();
            int units = sc.nextInt();

            if (units < 0) {
                System.out.println(room + ": invalid reading");
                continue;
            }

            long bill;

            if (units <= 100) {
                bill = units * 3L + 50;
            }
            else if (units <= 200) {
                bill = 100 * 3L +
                       (units - 100) * 5L + 50;
            }
            else {
                bill = 100 * 3L +
                       100 * 5L +
                       (units - 200) * 8L + 50;
            }

            System.out.println(room + ": " +
                units + " units, bill " + bill);

            roomsBilled++;
            grandTotal += bill;
        }

        System.out.println("Rooms billed " +
            roomsBilled + ", total " + grandTotal);

        sc.close();
    }
}
