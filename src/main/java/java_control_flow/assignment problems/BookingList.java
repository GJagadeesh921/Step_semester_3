
class BookingList {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node removeFirst(Node head, String booking) {

        if (head == null) {
            System.out.println(booking + " not found");
            return null;
        }

        if (head.data.equals(booking)) {
            return head.next;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.data.equals(booking)) {
                current.next = current.next.next;
                return head;
            }

            current = current.next;
        }

        System.out.println(booking + " not found");
        return head;
    }

    static void display(Node head) {

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node("104");
        head.next = new Node("101");
        head.next.next = new Node("107");
        head.next.next.next = new Node("101");

        head = removeFirst(head, "101");
        display(head);

        Node head2 = new Node("104");
        head2.next = new Node("101");
        head2.next.next = new Node("107");

        head2 = removeFirst(head2, "104");
        display(head2);

        Node head3 = new Node("104");
        head3.next = new Node("101");

        head3 = removeFirst(head3, "200");
        display(head3);
    }
}
