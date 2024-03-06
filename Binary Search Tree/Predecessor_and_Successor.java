class Predecessor_and_Successor {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static Node root;
    static Node pre = null, suc = null;

    public static void findPreSuc(Node root, int key) {
        Node p1 = root;
        Node p2 = root;
        while (p1 != null || p2 != null) {
            if (p2 != null) {
                if (p2.data <= key) {
                    p2 = p2.right;
                } else {
                    suc = p2;
                    p2 = p2.left;
                }
            }
            if (p1 != null) {
                if (p1.data >= key) {
                    p1 = p1.left;
                } else {
                    pre = p1;
                    p1 = p1.right;
                }
            }
        }
    }
}