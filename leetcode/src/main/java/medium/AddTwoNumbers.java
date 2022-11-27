package medium;

import util.ListNode;

import static org.junit.Assert.assertEquals;

/**
 * 2. Add Two Numbers
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        var l1 = ListNode.from(2, 4, 3);
        var l2 = ListNode.from(5,6,4);
        var expected = ListNode.from(7,0,8);
        var solution = new AddTwoNumbers();
        assertEquals(expected.toString(), solution.addTwoNumbers2(l1, l2).toString());
//        var l1 = ListNode.from(9);
//        var l2 = ListNode.from(1, 9, 9, 9, 9, 9, 9, 9, 9, 9);
//        var expected = ListNode.from(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
//        var solution = new AddTwoNumbers();
//        assertEquals(expected.toString(), solution.addTwoNumbers2(l1, l2).toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long number1 = l1.val;
        long index1 = 10;
        while (l1.next != null) {
            l1 = l1.next;
            number1 += l1.val * index1;
            index1 *= 10;
        }
        long number2 = l2.val;
        long index2 = 10;
        while (l2.next != null) {
            l2 = l2.next;
            number2 += l2.val * index2;
            index2 *= 10;
        }
        long add = number1 + number2;
        ListNode answer = new ListNode((int) (add % 10));
        ListNode currentNode = answer;
        add /= 10;
        while (add != 0) {
            currentNode.next = new ListNode((int) (add % 10));
            currentNode = currentNode.next;
            add /= 10;
        }
        return answer;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int val1 = l1.val;
        int val2 = l2.val;
        int sum = val1 + val2;
        int tmp = 0;
        if (sum > 9) {
            tmp = sum / 10;
            sum %= 10;
        }
        val1 = 0;
        val2 = 0;
        ListNode answer = new ListNode(sum);
        ListNode current = answer;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            sum = val1 + val2 + tmp;
            tmp = 0;
            if (sum > 9) {
                tmp = sum / 10;
                sum %= 10;
            }
            current.next = new ListNode(sum);
            current = current.next;
            val1 = 0;
            val2 = 0;
        }
        if (tmp != 0) {
            current.next = new ListNode(tmp);
        }
        return answer;
    }
}
