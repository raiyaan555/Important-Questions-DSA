package Linked_List;

import Linked_List.Merge_Two_Sorted_List.ListNode;

public class Delete_Node_in_Linked_List {
    public void deleteNode(ListNode t) {

        if (t == null)
            return;
        t.val = t.next.val;
        t.next = t.next.next;

    }
}
