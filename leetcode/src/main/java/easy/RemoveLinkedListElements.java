package easy;

import org.junit.Assert;
import util.ListNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
//        Input: head = [1,2,6,3,4,5,6], val = 6
//        Output: [1,2,3,4,5]
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        Assert.assertEquals("12345", new RemoveLinkedListElements().removeElements(head, 6).toString());

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-1, head);
        ListNode current = result;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return result.next;
    }
}
