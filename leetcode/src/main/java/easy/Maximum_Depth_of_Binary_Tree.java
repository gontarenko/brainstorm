package easy;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        root.right = new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)));

        new Maximum_Depth_of_Binary_Tree().maxDepth(root);
    }

    public int maxDepth(TreeNode root) {
        // return maxDepthRecursion(root, 0);
        return maxDepthIterate(root);
    }

    public int maxDepthRecursion(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        int l = maxDepthRecursion(node.left, 0);
        int r = maxDepthRecursion(node.right, 0);
        return Math.max(l, r) + 1;
    }

    public int maxDepthIterate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 1));
        int max = 0;

        while (!stack.isEmpty()) {
            Pair pair = stack.poll();

            TreeNode node = pair.node;
            int depth = pair.depth;
            if (node == null) {
                continue;
            }
            max = Math.max(depth, max);

            stack.push(new Pair(node.right, depth + 1));
            stack.push(new Pair(node.left, depth + 1));
        }
        return max;
    }

    class Pair {
        public TreeNode node;
        public int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
