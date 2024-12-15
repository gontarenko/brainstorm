package medium;

import util.ListNode;

public class Swap_Nodes_in_Pairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr = first;
        }
        return dummy.next;
    }
}
