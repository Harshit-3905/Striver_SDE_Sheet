import java.util.*;

class Symmetric_Tree {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(Solution(root.left, root.right));
        in.close();
    }

    static boolean Solution(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return Solution(root1.left, root2.right) && Solution(root1.right, root2.left);
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