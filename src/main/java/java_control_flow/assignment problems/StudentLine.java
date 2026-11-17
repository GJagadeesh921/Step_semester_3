
class StudentLine {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node addFirst(Node head, String name) {
        Node newNode = new Node(name);
        newNode.next = head;
        return newNode;
    }

    static Node addLast(Node head, String name) {
        Node newNode = new Node(name);

        if (head == null) {
            return newNode;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
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

        Node head = new Node("Asha");
        head.next = new Node("Ravi");

        head = addFirst(head, "Neha");
        head = addLast(head, "Kiran");
        head = addFirst(head, "Mohan");

        display(head);

        Node head2 = null;

        head2 = addLast(head2, "Pooja");
        head2 = addFirst(head2, "Arun");

        display(head2);
    }
}
