package Linked_List;

import java.util.HashSet;

public class Remove_duplicates_from_an_unsorted_linked_list {
    class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}
    public Node removeDuplicates(Node head) 
    {
         
         HashSet<Integer> mp = new HashSet<>();
         
         Node curr = head;
         Node prev = null;
         
         
         while(curr!=null){
             if(mp.contains(curr.data)){
                 prev.next = curr.next;
             }else{
                 mp.add(curr.data);
                 prev = curr;
             }
             curr =curr.next;
         }
         return head;
         
         
    }
}
