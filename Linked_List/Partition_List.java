package Linked_List;

import Linked_List.Linked_List_Cycle.ListNode;

public class Partition_List {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller =new ListNode(0);
        ListNode larger = new ListNode(0);

        ListNode curr1 = smaller;
        ListNode curr2 = larger;
        ListNode curr = head;

        while(curr!=null){
           if(curr.val>=x){
            curr2.next = curr;
            curr2 = curr2.next;
           }else{
               curr1.next = curr;
               curr1 = curr1.next;
           }
           curr = curr.next;
        }
        curr1.next = larger.next;
        curr2.next = null;
        return smaller.next;
    }
}
}
