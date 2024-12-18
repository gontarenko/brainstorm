package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFS {
    public static void main(String[] args) {
        Node root = new Node(
                new Node(new Node(4), new Node(5) , 2),
                new Node(new Node(6), new Node(7),3),
                1
        );
        dfsIteration(root);
    }

    public static void dfsRecursion(Node root) {
        if (root == null) {
            return;
        }
//        System.out.print(root.val + " "); // pre-order // 1 2 4 5 3 6 7
        dfsRecursion(root.left);
//        System.out.print(root.val + " "); // in-order  // 4 2 5 1 6 3 7
        dfsRecursion(root.right );
//        System.out.print(root.val + " "); // post-order  // 4 5 2 6 7 3 1

    }

    public static void dfsIteration(Node root) {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

//            System.out.print(node.val + " "); //
            if (node.right != null) {
                stack.push(node.right);
            }
//            System.out.print(node.val + " "); //
            if (node.left != null) {
                stack.push(node.left);
            }
//            System.out.print(node.val + " "); //
        }
    }

    static class Node {
        Node left;
        Node right;
        int val;

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
