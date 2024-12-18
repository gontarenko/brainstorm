package easy;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Path_Sum {
    public boolean hasPathSumRecursive(TreeNode node, int targetSum) {
        if (node == null) {
            return false;
        }

        targetSum -= node.val;

        if (node.left == null && node.right == null) {
            return targetSum == 0;
        }

        return hasPathSumRecursive(node.left, targetSum) || hasPathSumRecursive(node.right, targetSum);
    }

    public boolean hasPathSumIterative(TreeNode node, int targetSum) {
        Deque<Pair> stack = new ArrayDeque<>();

        stack.push(new Pair(node, 0));

        while (!stack.isEmpty()) {
            Pair p = stack.poll();

            node = p.n;
            if (node == null) {
                continue;
            }
            int currSum = p.sum + node.val;
            if (node.left == null && node.right == null && currSum == targetSum) {
                return true;
            }

            stack.push(new Pair(node.left, currSum));
            stack.push(new Pair(node.right, currSum));
        }

        return false;
    }

    class Pair {
        public TreeNode n;
        public int sum;

        public Pair(TreeNode n, int sum) {
            this.n = n;
            this.sum = sum;
        }
    }
}
