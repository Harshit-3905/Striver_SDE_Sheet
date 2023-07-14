import java.util.*;

class Balanced_Binary_Tree {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(Solution2(root));
        in.close();
    }

    static boolean Solution1(Node root) {
        return Math.abs(height(root.left) - height(root.right)) <= 1 && Solution1(root.left) && Solution1(root.right);
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + (Math.max(height(root.left), height(root.right)));
    }

    static boolean Solution2(Node root) {
        return dfsHeight(root) != -1;
    }

    static int dfsHeight(Node root) {
        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
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