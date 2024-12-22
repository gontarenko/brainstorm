package medium;

import org.apache.commons.math3.util.Pair;
import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Validate_Binary_Search_Tree {

    public boolean isValidBST(TreeNode root) {
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        while (!stack.isEmpty()) {
            Pair data = stack.poll();
            TreeNode node = data.node;
            if (node == null) {
                continue;
            }
            if (node.val <= data.from || node.val >= data.to) {
                return false;
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, data.from, Double.valueOf(node.val)));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, Double.valueOf(node.val), data.to));
            }
        }
        return true;
    }
    class Pair {
        TreeNode node;
        Double from;
        Double to;

        public Pair(TreeNode node, Double from, Double to) {
            this.node = node;
            this.from = from;
            this.to = to;
        }
    }
}
