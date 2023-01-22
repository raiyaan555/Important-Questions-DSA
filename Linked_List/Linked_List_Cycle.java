package Linked_List;

public class Linked_List_Cycle {
    class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                 val = x;
                 next = null;
             }
         }

         public class Solution {
            public boolean hasCycle(ListNode head) {
                ListNode fast = head;
                ListNode slow = head;
        
                while(fast!=null && fast.next!=null){
                    fast = fast.next.next;
                    slow = slow.next;
        
                    if(fast==slow){
                        return true;
                    }
                }
                return false;
            }
}
}
