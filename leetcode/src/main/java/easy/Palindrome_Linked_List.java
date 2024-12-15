package easy;

import util.ListNode;

public class Palindrome_Linked_List {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = middleNode(head);
        middle = reverseList(middle);

        while (head.next != null && middle.next != null) {
            if (head.val != middle.val) {
                return false;
            }
            head = head.next;
            middle = middle.next;
        }
        return head.val == middle.val;
    }

    private static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
