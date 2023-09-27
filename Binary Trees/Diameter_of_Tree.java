class Diameter_of_Tree {
    int max;

    public int diameterOfBinaryTree(Node root) {
        max = 0;
        helper(root);
        return max - 1;
    }

    int helper(Node root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, 1 + left + right);
        return 1 + Math.max(left, right);
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