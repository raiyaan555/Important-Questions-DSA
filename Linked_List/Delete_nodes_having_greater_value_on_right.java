package Linked_List;

public class Delete_nodes_having_greater_value_on_right {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node reverse(Node head) {

        if (head == null || head.next == null) {

            return head;

        }

        Node curr = head;

        Node prev = null;

        while (curr != null) {

            Node next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;

        }
        return prev;

    }

    Node compute(Node head) {
        // your code here

        if (head == null || head.next == null) {
            return head;
        }

        head = this.reverse(head);
        Node temp = head;

        while (temp.next != null) {
            if (temp.data <= temp.next.data) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }

        }

        head = this.reverse(head);
        return head;
    }
}