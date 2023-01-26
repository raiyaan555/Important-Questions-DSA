package Linked_List;

public class Segregate_even_and_odd_nodes_in_LinkList {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    Node divide(int N, Node head) {
        // code here
        Node even = null;
        Node odd = null;
        Node e = null;
        Node o = null;

        while (head != null) {
            if (head.data % 2 == 0) {
                if (even == null) {
                    even = head;
                    e = head;
                } else {
                    e.next = head;
                    e = e.next;
                }
            } else {
                if (odd == null) {
                    odd = head;
                    o = head;
                } else {
                    o.next = head;
                    o = o.next;
                }

            }
            head = head.next;
        }

        if (e != null) {
            e.next = odd;
        }
        if (o != null) {
            o.next = null;
        }
        if (even != null) {
            return even;
        }
        return odd;

    }
}
