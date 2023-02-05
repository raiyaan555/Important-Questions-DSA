package Stack_and_Queues;

public class Design_a_stack_with_operations_on_middle_element {

    Design_a_stack_with_operations_on_middle_element prev;
    Design_a_stack_with_operations_on_middle_element next;
    int data;

    Design_a_stack_with_operations_on_middle_element(int data) {
        this.data = data;
    }
}

class myStack {

    Design_a_stack_with_operations_on_middle_element head;
    Design_a_stack_with_operations_on_middle_element mid;
    Design_a_stack_with_operations_on_middle_element prev;
    Design_a_stack_with_operations_on_middle_element next;
    int size;

    void push(int data) {
        Design_a_stack_with_operations_on_middle_element newNode = new Design_a_stack_with_operations_on_middle_element(
                data);
        if (size == 0) {
            head = newNode;
            mid = newNode;
            size++;
            return;
        }
        head.next = newNode;
        newNode.prev = head;

        head = head.next;

        if (size % 2 != 0) {
            mid = mid.next;
        }
        size += 1;
    }

    int pop() {
        int data = -1;
        if (size == 0) {
            return -1;
        }

        if (size != 0) {
            if (size == 1) {
                head = null;
                mid = null;
            } else {
                data = head.data;
                head = head.prev;
                head.next = null;

                if (size % 2 == 0) {
                    mid = mid.prev;
                }
            }
            size--;
        }
        return data;
    }

    int findMiddle() {
        if (size == 0) {
            System.out.println("Stack is empty now");
            return -1;
        }
        return mid.data;
    }

    void deleteMiddleElement() {
        if (size != 0) {
            if (size == 1) {
                head = null;
                mid = null;
            } else if (size == 2) {
                head = head.prev;
                mid = mid.prev;
                head.next = null;
            } else {
                mid.next.prev = mid.prev;
                mid.prev.next = mid.next;
                if (size % 2 == 0) {
                    mid = mid.prev;
                } else {
                    mid = mid.next;
                }
            }
            size--;
        }
    }

    public static void main(String args[]) {
        myStack ms = new myStack();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);

        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : "
                + ms.findMiddle());
        ms.deleteMiddleElement();
        System.out.println("New Middle Element : "
                + ms.findMiddle());
    }
}
