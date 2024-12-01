package easy;

import util.ListNode;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

public class Linked_List_Cycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleIdentity(ListNode head) {
        if (head == null) {
            return false;
        }
        // identity hash set...
        Set<ListNode> seen = Collections.newSetFromMap(new IdentityHashMap<>());
        seen.add(head);

        ListNode current = head.next;
        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }
            seen.add(current);
            current = current.next;
        }
        return false;
    }
}
