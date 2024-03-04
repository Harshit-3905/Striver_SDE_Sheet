class Floor_in_BST {
    public static int floor(Node root, int x) {
        int ans = -1;
        while (root != null) {
            if (x > root.data) {
                ans = root.data;
                root = root.right;
            } else if (x < root.data) {
                root = root.left;
            } else
                return root.data;
        }
        return ans;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}