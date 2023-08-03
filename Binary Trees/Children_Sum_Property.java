
class Children_Sum_Property {

    public static boolean Solution(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        int l = 0, r = 0;
        if (root.left != null)
            l = root.left.data;
        if (root.right != null)
            r = root.right.data;
        return (l + r == root.data) && Solution(root.left) && Solution(root.right);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}