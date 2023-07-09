import java.util.*;

class Height_of_Tree {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        int ans = Solution(root);
        System.out.println(ans);
        in.close();
    }

    static int Solution(Node root) {
        if (root == null)
            return 0;
        return 1 + (Math.max(Solution(root.left), Solution(root.right)));
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