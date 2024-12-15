package medium;

import util.ListNode;

public class Delete_the_Middle_Node_of_a_Linked_List {
    public static void main(String[] args) {

    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //    [1, 2, 3, 4, 5, 6, 7, 8]
        // 1:  s     f
        // 2:     s        f
        // 3:        s           f
        // 4:           s             f
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;

        return head;
    }


    public ListNode deleteMiddleDummy(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode prevSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = prevSlow.next.next;

        return head;
    }
}
