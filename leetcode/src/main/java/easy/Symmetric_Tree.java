package easy;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Symmetric_Tree {

    // recursion
    public boolean isSymmetricRecursion(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null || n1.val != n2.val) {
            return false;
        }
        return isSymmetric(n1.left, n2.right) && isSymmetric(n1.right, n2.left);
    }


    // iteration
    public boolean isSymmetricIterate(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode l = stack.poll();
            TreeNode r = stack.poll();

            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null || l.val != r.val) {
                return false;
            }

            stack.push(r.right);
            stack.push(l.left);

            stack.push(r.left);
            stack.push(l.right);
        }

        return true;
    }

}
