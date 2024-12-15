package easy;

import util.ListNode;

public class MiddleOfLinkList {

    public static void main(String[] args) {
        // [1,2,3,4,5, 6]
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))) );
        System.out.println(middleNode(head));
    }

    public static ListNode middleNode(ListNode head) {
        ListNode begin = head;
        int beginIndex = 0;
        ListNode curr = head;
        int currIndex = 0;
        while (curr.next != null) {
            curr = curr.next;
            currIndex++;
            while ((currIndex / 2) > beginIndex) {
                begin = begin.next;
                beginIndex++;
            }
        }
        begin = begin.next;
        return begin;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
