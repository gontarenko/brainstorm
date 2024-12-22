package medium;

import util.TreeNode;

public class Insert_into_a_Binary_Search_Tree {

    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertIntoBST(node.left, val);
        } else {
            node.right = insertIntoBST(node.right, val);
        }

        return node;
    }
}
