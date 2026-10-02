import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected LocalDate currentDate;

    public LibraryItem(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public abstract int getBorrowDays();

    public abstract String getType();

    public LocalDate calculateDueDate() {
        return currentDate.plusDays(getBorrowDays());
    }
}

class Book extends LibraryItem {

    public Book(LocalDate currentDate) {
        super(currentDate);
    }

    @Override
    public int getBorrowDays() {
        return 14;
    }

    @Override
    public String getType() {
        return "BOOK";
    }
}

class DVD extends LibraryItem {

    public DVD(LocalDate currentDate) {
        super(currentDate);
    }

    @Override
    public int getBorrowDays() {
        return 7;
    }

    @Override
    public String getType() {
        return "DVD";
    }
}

class Magazine extends LibraryItem {

    public Magazine(LocalDate currentDate) {
        super(currentDate);
    }

    @Override
    public int getBorrowDays() {
        return 3;
    }

    @Override
    public String getType() {
        return "MAGAZINE";
    }
}

public class LibraryItemDueDateCalculator {

    public static LibraryItem createItem(
            String type, LocalDate currentDate) {

        switch (type) {

            case "BOOK":
                return new Book(currentDate);

            case "DVD":
                return new DVD(currentDate);

            case "MAGAZINE":
                return new Magazine(currentDate);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String date = sc.next();

            LocalDate currentDate =
                    LocalDate.parse(date);

            LibraryItem item =
                    createItem(type, currentDate);

            LocalDate dueDate =
                    item.calculateDueDate();

            System.out.printf(
                    "%s: %s%n",
                    item.getType(),
                    dueDate
            );
        }

        sc.close();
    }
}
