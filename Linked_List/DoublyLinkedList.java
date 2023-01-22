package Linked_List;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node n = new Node(val);
        if (head != null) {
            head.prev = n;
        }
        n.prev = null;
        n.next = head;
        head = n;

        size++;
    }

    public void display(){
        Node temp = head;
        Node last = null;

        while(temp!=null){
            System.out.print(temp.value+" -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

        while(last!=null){
            System.out.print(last.value+" -> ");
            last = last.prev;
        }
        System.out.println("END");

    }



    public void insertLast(int val){
        Node temp = head;
        Node n = new Node(val);
      


        if(head == null){
            n.prev = null;
            head = n;
            return;
        }


        while(temp.next!=null){
            temp = temp.next;
        }

        temp.next = n;
        n.next = null;
        n.prev = temp;

        size++;
    }

    public void insert(int value, int i){
        Node temp = head;
        Node node = new Node(value);
        int counter = 1;

        if(i==0){
            insertFirst(value);
            return;
        }

        if(i==size){
            insertLast(value);
            return;
        }

        while(counter<i){
            counter++;
            temp = temp.next;
        }
        Node t = temp.prev;
        temp.prev = node;
        node.prev = t;
        node.next = temp;

        size++;
    }

    

    private class Node {

        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.prev = previous;
        }

        public static void main(String[] args) {
            DoublyLinkedList list = new DoublyLinkedList();
            list.insertFirst(5);
            list.insertFirst(4);
            list.insertFirst(3);
            list.insertFirst(2);
            list.insertFirst(1);
            list.insertFirst(0);
            // list.display();
            list.insertLast(6);
            // list.display();
            list.insert(9,4);
            list.display();


        }

    }
}
