class Kth_Largest_Element_in_BST {

    static int count = 0;

    static int kthLargest(Node root, int k) {
        if (root == null)
            return -1;

        int right = kthLargest(root.right, k);
        if (right != -1)
            return right;

        count++;
        if (count == k)
            return root.data;

        return kthLargest(root.left, k);
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
