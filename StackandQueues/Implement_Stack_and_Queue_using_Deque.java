package StackandQueues;

import java.util.Deque;

public class Implement_Stack_and_Queue_using_Deque {
    static class DeQueNode {
        int value;
        DeQueNode next;
        DeQueNode prev;
    }

    static class deque {
        private DeQueNode head;
        private DeQueNode tail;

        public deque() {
            head = tail = null;
        }

        boolean isEmpty() {
            if (head == null)
                return true;

            return false;
        }

        int size() {
            if (!isEmpty()) {
                DeQueNode temp = head;
                int len = 0;

                while (temp != null) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            return 0;
        }

        void insertFirst(int element) {
            DeQueNode temp = new DeQueNode();
            temp.value = element;

            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
        }

        void insertLast(int element) {
            DeQueNode temp = new DeQueNode();
            temp.value = element;

            if (head == null) {
                head = tail = null;
                temp.next = temp.prev = null;
            }

            else {

                tail.next = temp;
                temp.next = null;
                temp.prev = tail;
                tail = temp;

            }
        }

        void removeFirst() {

            if (!isEmpty()) {
                DeQueNode temp = head;
                head = head.next;
                head.prev = null;

                return;
            }

            System.out.println("List is empty");
        }

        void removeLast() {

            if (!isEmpty()) {
                DeQueNode temp = tail;
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }

                return;
            }

            System.out.println("List is empty");
        }

        void display() {

            if (!isEmpty()) {
                DeQueNode temp = head;

                while (temp != null) {
                    System.out.print(temp.value + " ");
                    temp = temp.next;
                }

                return;
            }
            System.out.print("List is Empty");
        }

    }

    static class Stack {
        deque d = new deque();

        public void push(int element) {
            d.insertLast(element);
        }

        public int size() {
            return d.size();
        }

        
        public void pop() {
            d.removeLast();
        }

        public void display() {
            d.display();
        }
    }

    static class Queue {
        deque d = new deque();

        public void enqueue(int element) {
            d.insertLast(element);
        }

        public void dequeue() {
            d.removeFirst();
        }

        public void display() {
            d.display();
        }

        public int size() {
            return d.size();
        }
    }

    public static void main(String[] args) {

        Stack stk = new Stack();

        stk.push(7);
        stk.push(8);
        System.out.print("Stack: ");
        stk.display();

        
        System.out.println();

        
        stk.pop();
        System.out.print("Stack: ");
        stk.display();

      
        System.out.println();

       
        Queue que = new Queue();

       
        que.enqueue(12);
        que.enqueue(13);
        System.out.print("Queue: ");
        que.display();

       
        System.out.println();

        
        que.dequeue();
        System.out.print("Queue: ");
        que.display();

       
        System.out.println();
        System.out.println("Size of stack is " +
                stk.size());
        System.out.println("Size of queue is " +
                que.size());
    }
}
