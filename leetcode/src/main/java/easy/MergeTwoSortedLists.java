package easy;

import util.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        // Input: list1 = [1,2,4], list2 = [1,3,4]
        // Output: [1,1,2,3,4,4]
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode head = mergeTwoLists(list1, list2);
        System.out.println(head);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();

        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode curr = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }

            curr = curr.next;
        }

        if (p1 != null) {
            curr.next = p1;
        }
        if (p2 != null) {
            curr.next = p2;
        }

        return dummy.next;
    }

}
