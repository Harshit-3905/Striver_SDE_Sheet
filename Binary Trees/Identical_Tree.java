import java.util.*;

class Identical_Tree {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        System.out.println(Solution(root1, root2));
        in.close();
    }

    static boolean Solution(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return Solution(root1.left, root2.left) && Solution(root1.right, root2.right);
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