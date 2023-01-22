package Linked_List;

public class Merge_Two_Sorted_List {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode point = res;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                point.next = list1;
                list1 = list1.next;
            } else {
                point.next = list2;
                list2 = list2.next;
            }

            point = point.next;
        }

        point.next = list1 != null ? list1 : list2;
        return res.next;
    }
}
