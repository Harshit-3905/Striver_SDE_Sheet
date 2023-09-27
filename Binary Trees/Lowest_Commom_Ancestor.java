
class Lowest_Commom_Ancestor {
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null)
            return root;
        if (root == p || root == q)
            return root;
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
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