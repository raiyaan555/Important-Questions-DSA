package Linked_List;

import Linked_List.Remove_nth_node_from_end.ListNode;

public class Reverse_Nodes_in_K_group {
    static int lengthOfLinkedList(ListNode head) {
        int length = 0;
        while(head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
    //utility function to reverse k nodes in the list
    
    static ListNode reverseKGroup(ListNode head,int k) {
        if(head == null||head.next == null) return head;
        
        int length = lengthOfLinkedList(head);
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode pre = dummyHead;
        ListNode cur;
        ListNode nex;
        
        while(length >= k) {
            cur = pre.next;
            nex = cur.next;
            for(int i=1;i<k;i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            length -= k;
        }
        return dummyHead.next;
    }
}
