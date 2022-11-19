package medium;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 112. Path Sum
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null);
        root.right = new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)));
        var solution = new PathSum();
        assertTrue(solution.hasPathSum(root, 22));
        assertFalse(solution.hasPathSum(new TreeNode(1, new TreeNode(2), null), 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Integer> sum = new ArrayDeque<>();
        nodes.addLast(root);
        sum.addLast(root.val);

        TreeNode currentNode = nodes.peekLast();
        int currentSum = sum.peekLast();

        while (!nodes.isEmpty() || currentNode != null) {

            while (currentNode != null) {
                currentNode = currentNode.left;
                if (currentNode != null) {
                    nodes.addLast(currentNode);
                    sum.addLast(currentSum += currentNode.val);
                }
            }
            currentNode = nodes.pollLast();
            currentSum = sum.pollLast();

            if (targetSum == currentSum && currentNode.left == null && currentNode.right == null) {
                return true;
            }

            currentNode = currentNode.right;
            if (currentNode != null) {
                nodes.addLast(currentNode);
                sum.addLast(currentSum += currentNode.val);
            }
        }
        return false;
    }
}
