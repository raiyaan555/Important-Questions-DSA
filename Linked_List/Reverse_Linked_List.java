package Linked_List;
import java.util.*;
public class Reverse_Linked_List {

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         
         public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode present = head;
            
   
           while(present!=null){
               ListNode next = present.next;
               present.next = prev;
               prev = present;
               present = next;
           }
   
           return prev;
   
          
       }
}
}


