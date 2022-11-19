package easy;

import util.ListNode;

public class ConvertBinaryNumberToInteger {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(0, new ListNode(1)));
        assert  5 == new Solution().getDecimalValue(listNode);
    }
    static class Solution {
        public int getDecimalValue(ListNode head) {
            StringBuilder binary = new StringBuilder();
            while (head.next != null) {
                binary.append(head.val);
                head = head.next;
            }
            binary.append(head.val);
            return Integer.parseInt(binary.toString(), 2);
        }
    }
}
