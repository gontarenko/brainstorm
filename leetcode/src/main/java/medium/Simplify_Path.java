package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Simplify_Path {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String p : path.split("/")) {
            if (p.isEmpty() || p.equals(".")) {
                continue;
            }
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.addLast(p);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
            if (!stack.isEmpty()) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
