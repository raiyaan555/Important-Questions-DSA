package Linked_List;

// y linked intersection point

public class Intersection_Point_in_Y_Shapped_Linked_Lists {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head; // head of list

    int intersectPoint(Node head1, Node head2) {
        Node a = head1;
        Node b = head2;

        while (a != b) {
            if (a == null)

                a = head2;
            else {
                a = a.next;

            }
            if (b == null) {
                b = head1;

            } else {
                b = b.next;

            }

        }
        return a.data;
    }
}
