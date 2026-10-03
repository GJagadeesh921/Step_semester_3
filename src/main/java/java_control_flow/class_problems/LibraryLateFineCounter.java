import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int lateDays;

    public LibraryItem(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    public abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {

    public Book(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    public double calculateFine() {
        return lateDays * 2.0;
    }
}

class DVD extends LibraryItem {

    public DVD(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    public double calculateFine() {
        double fine = lateDays * 5.0;

        if (fine > 50) {
            fine = 50;
        }

        return fine;
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    public double calculateFine() {
        return lateDays * 1.0;
    }
}

public class LibraryLateFineCounter {

    public static LibraryItem createItem(
            String type,
            String title,
            int lateDays) {

        switch (type) {

            case "BOOK":
                return new Book(title, lateDays);

            case "DVD":
                return new DVD(title, lateDays);

            case "MAGAZINE":
                return new Magazine(title, lateDays);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalFine = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int lateDays = sc.nextInt();

            LibraryItem item =
                    createItem(type, title, lateDays);

            double fine = item.calculateFine();

            System.out.printf(
                    "%s: %.2f%n",
                    item.getTitle(),
                    fine
            );

            totalFine += fine;
        }

        System.out.printf(
                "Total Fine: %.2f%n",
                totalFine
        );

        sc.close();
    }
}
