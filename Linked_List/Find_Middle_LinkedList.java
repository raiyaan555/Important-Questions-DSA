package Linked_List;

import Linked_List.Linked_List_Cycle.ListNode;

public class Find_Middle_LinkedList {
    public ListNode middleNode(ListNode head) {

        ListNode curr = head;
        int c = 0;

        while(curr!=null){
            curr = curr.next;
            c++;
        }

        c = c/2;
        curr = head;
        int c2 = 0;

        while(c2!=c && curr!=null){
            curr = curr.next;
            c2++;
        }
        return curr;
        
    }
}
