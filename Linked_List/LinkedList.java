package Linked_List;

public class LinkedList {

    private Node head;
    private Node tail;

    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");

    }

    public void insertFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        head = node;

        if (tail == head) {
            tail = head;
        }

        size += 1;

    }

    public void insertlast(int val) {
        Node node = new Node(val);

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = null;
        tail = node;

        if (tail == null) {
            insertFirst(val);
            return;
        }

        /*
         * tail.next = node;
         * tail = node;
         */

        size++;
    }

    public void insertBetween(int val, int i) {

        if (i == 0) {
            insertFirst(val);
            return;
        }

        if (i == size) {
            insertlast(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head;
        int c = 1;

        while (temp.next != null && c + 1 < i) {
            temp = temp.next;
            c++;
        }
        Node t = temp.next;
        temp.next = node;
        node.next = t;
        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return val;

    }

    public int deleteLast() {
        int val = tail.value;

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;

        if (tail == null) {
            head = null;
        }

        size--;

        return val;

    }

    public int delete(int i) {
        if (i == 0) {
            return deleteLast();
        }

        if (i == size - 1) {
            return deleteLast();
        }

        Node prev = head;
        int c = 1;
        while (c + 1 < i) {
            c++;
            prev = prev.next;
        }

        int t = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return t;

    }

    private class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public static void main(String[] args) {
            LinkedList ll = new LinkedList();
            ll.insertFirst(2);
            ll.insertFirst(3);
            ll.insertFirst(3);
            ll.insertFirst(3);
            ll.insertFirst(3);
            ll.insertlast(2);
            ll.insertBetween(4, 4);
            ll.display();

            System.out.println(ll.deleteFirst());
            System.out.println(ll.deleteLast());
            System.out.println(ll.delete(3));

            ll.display();

        }

    }
}