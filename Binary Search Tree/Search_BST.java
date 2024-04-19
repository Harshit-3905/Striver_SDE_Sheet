class Search_BST {

    static Node searchBST(Node root, int val) {
        if (root == null || root.val == val)
            return root;
        if (root.val < val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
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