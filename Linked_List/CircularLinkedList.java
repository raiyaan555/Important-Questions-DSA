package Linked_List;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    private int size;

    CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        Node temp = head;

        if (head != null) {
            do {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("END");
        }
        size++;
    }

    public void delete(int val) {
        Node node = head;
        if (node == null) {
            return;
        }

        if (head.value == val) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
            if (n.value == val) {
                node.next = n.next;
                break;
            }

        } while (node != head);

    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public static void main(String[] args) {
            CircularLinkedList list = new CircularLinkedList();
            // list.display();
            list.insert(6);
            list.insert(5);
            list.insert(4);
            list.insert(3);
            list.insert(2);
            list.insert(1);
            list.insert(0);
            list.delete(5);
            list.display();

        }
    }
}
