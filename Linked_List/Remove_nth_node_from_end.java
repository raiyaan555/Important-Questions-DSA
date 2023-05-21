package Linked_List;

public class Remove_nth_node_from_end {
    
// brute solution

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if(head.next == null){
            return null;
        }
        
        ListNode curr = head;
        int size = 0;
        
        while(curr != null){
            curr = curr.next;
            size++;
        }
        
        if(n==size){
            return head.next;
        }
        
        ListNode prev = head;
        int i = 1;
        while(i<size-n){
            prev = prev.next;
            i++;
        }
        
        prev.next = prev.next.next;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }
}
