package easy;

import util.TreeNode;

public class Invert_Binary_Tree {
    public TreeNode invertTreeRecurisve(TreeNode node) {
        if (node == null) {
            return null;
        }

        invertTreeRecurisve(node.left);
        invertTreeRecurisve(node.right);

        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;

        return node;
    }
}
