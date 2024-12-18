package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

public class Valid_Parentheses {
    private static final Map<Character, Character> mirror = Map.of(
            '}', '{',
            ')', '(',
            ']', '['
    );

    private static final Set<Character> openBrackets = Set.of('{','(','[');

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (openBrackets.contains(bracket)) {
                stack.addLast(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char openBracket = stack.pollLast();
                if (mirror.get(bracket) != openBracket) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
