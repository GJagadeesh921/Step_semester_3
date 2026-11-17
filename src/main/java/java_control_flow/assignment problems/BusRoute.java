
class BusRoute {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node build(String[] stops) {

        Node head = null;
        Node tail = null;

        for (String stop : stops) {
            Node newNode = new Node(stop);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    static void printRoute(Node head) {

        Node current = head;
        int count = 0;
        String first = "";
        String last = "";

        while (current != null) {

            System.out.print(current.data + " -> ");

            if (count == 0) {
                first = current.data;
            }

            last = current.data;
            count++;

            current = current.next;
        }

        System.out.println("null");
        System.out.println("Stops: " + count +
                ", First: " + first +
                ", Last: " + last);
    }

    public static void main(String[] args) {

        String[] stops = {
            "Tambaram", "Guindy", "TNagar", "Central"
        };

        Node head = build(stops);
        printRoute(head);

        String[] stops2 = {"Potheri"};

        Node head2 = build(stops2);
        printRoute(head2);
    }
}
