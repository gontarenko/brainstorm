package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Removing_Stars_From_a_String {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '*' && !stack.isEmpty()) {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }
}
