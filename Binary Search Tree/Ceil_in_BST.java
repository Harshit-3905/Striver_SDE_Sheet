class Ceil_in_BST {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        int ans = -1;
        while (root != null) {
            if (key > root.data) {
                root = root.right;
            } else if (key < root.data) {
                ans = root.data;
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
