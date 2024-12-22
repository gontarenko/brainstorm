package easy;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Search_in_a_Binary_Search_Tree {
    // recursive
    public TreeNode searchBST(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return node;
        }
        if (val < node.val) {
            return searchBST(node.left, val);
        } else {
            return searchBST(node.right, val);
        }
    }

    // iterative
    public TreeNode searchBST_iterative(TreeNode node, int val) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.poll();
            if (node == null) {
                continue;
            }
            if (node.val == val) {
                return node;
            }
            if (node.val < val) {
                stack.push(node.right);
            } else {
                stack.push(node.left);
            }
        }

        return null;
    }
}
