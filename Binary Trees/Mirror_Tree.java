import java.util.*;

class Mirror_Tree {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        Solution(root);
        in.close();
    }

    static void Solution(Node root) {
        if (root == null)
            return;
        Node x = root.right;
        root.right = root.left;
        root.left = x;
        Solution(root.left);
        Solution(root.right);
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
        left = null;
        right = null;
    }
}