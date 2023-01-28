package Linked_List;

import java.io.*;
import java.util.*;

class Sort_Biotonic_Doubly_List {

    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static Node reverse(Node head_ref) {
        Node temp = null;
        Node current = head_ref;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null)
            head_ref = temp.prev;
        return head_ref;
    }

    static Node merge(Node first, Node second) {

        if (first == null)
            return second;

        if (second == null)
            return first;

        if (first.data < second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    static Node sort(Node head) {

        if (head == null || head.next == null)
            return head;

        Node current = head.next;

        while (current != null) {

            if (current.data < current.prev.data)
                break;

            current = current.next;
        }

        if (current == null)
            return head;

        current.prev.next = null;
        current.prev = null;

        current = reverse(current);

        return merge(head, current);
    }

    static Node push(Node head_ref, int new_data) {

        Node new_node = new Node();

        new_node.data = new_data;

        new_node.prev = null;

        new_node.next = (head_ref);

        if ((head_ref) != null)
            (head_ref).prev = new_node;

        (head_ref) = new_node;
        return head_ref;
    }

    static void printList(Node head) {

        if (head == null)
            System.out.println("Doubly Linked list empty");

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        Node head = null;

        head = push(head, 1);
        head = push(head, 4);
        head = push(head, 6);
        head = push(head, 10);
        head = push(head, 12);
        head = push(head, 7);
        head = push(head, 5);
        head = push(head, 2);

        System.out.println("Original Doubly linked list:");
        printList(head);

        head = sort(head);

        System.out.println(
                "\nDoubly linked list after sorting:");
        printList(head);
    }
}
