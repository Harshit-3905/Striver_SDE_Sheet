import java.util.*;

class Flatten_Binary_Tree_to_Linked_List {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(5);
        root.right.right = new Node(6);
        flatten(root);
        Node curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        in.close();
    }

    static Node flatten(Node root) {
        if (root == null)
            return root;
        Node left = flatten(root.left);
        Node right = flatten(root.right);
        if (left != null) {
            Node curr = left;
            while (curr.right != null)
                curr = curr.right;
            curr.right = right;
            root.right = left;
            root.left = null;
        }
        return root;
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