package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Remove_All_Adjacent_Duplicates_In_String {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(c);
            } else {
                char another = stack.peekLast();
                if (c != another) {
                    stack.addLast(c);
                } else {
                    stack.pollLast();
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }
}
