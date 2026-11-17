
import java.util.Scanner;

public class LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] stack = new String[3];
        String[] queue = new String[3];

        int top = -1;

        int front = 0;
        int rear = -1;
        int size = 0;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            if (command.equals("RETURN")) {
                String book = sc.next();

                if (top == 2) {
                    System.out.println(book +
                        " rejected: pile is full");
                } else {
                    stack[++top] = book;
                    System.out.println(book +
                        " placed on pile");
                }
            }

            else if (command.equals("SHELVE")) {
                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    System.out.println("shelved " + stack[top]);
                    stack[top] = null;
                    top--;
                }
            }

            else if (command.equals("WAIT")) {
                String student = sc.next();

                if (size == 3) {
                    System.out.println("line is full");
                } else {
                    rear = (rear + 1) % 3;
                    queue[rear] = student;
                    size++;

                    System.out.println(student +
                        " joined the line");
                }
            }

            else if (command.equals("SERVE")) {
                if (size == 0) {
                    System.out.println("no one waiting");
                } else {
                    System.out.println("served " + queue[front]);

                    queue[front] = null;
                    front = (front + 1) % 3;
                    size--;
                }
            }
        }

        sc.close();
    }
}
