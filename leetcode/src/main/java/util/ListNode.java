package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode currentNode = this;
        while (currentNode != null) {
            sb.append(currentNode.val);
            currentNode = currentNode.next;
        }
        return sb.toString();
    }

    public static ListNode from(int... values) {
        ListNode root = new ListNode(values[0]);
        ListNode current = root;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return root;
    }
}