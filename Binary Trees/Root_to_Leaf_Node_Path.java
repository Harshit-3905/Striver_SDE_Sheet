import java.util.*;

class Root_to_Leaf_Node_Path {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        ArrayList<String> ans = new ArrayList<>();
        Solution(root, "", ans);
        for (String s : ans)
            System.out.println(s);
        in.close();
    }

    static void Solution(Node root, String s, ArrayList<String> ans) {
        s = s + root.val + " ";
        if (root.left == null && root.right == null) {
            ans.add(s);
            return;
        }
        if (root.left != null)
            Solution(root.left, s, ans);
        if (root.right != null)
            Solution(root.right, s, ans);
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