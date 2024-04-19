class Largest_BST_in_Binary_Tree {
    static int largestBst(Node root) {
        return helper(root).count;
    }

    static Tuple helper(Node root) {
        if (root == null) {
            return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
        Tuple left = helper(root.left);
        Tuple right = helper(root.right);
        if (root.data > left.largest && root.data < right.smallest) {
            return new Tuple(Math.max(right.largest, root.data), Math.min(left.smallest, root.data),
                    1 + left.count + right.count);
        }
        return new Tuple(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(left.count, right.count));
    }

}

class Tuple {
    int largest, smallest, count;

    Tuple(int a, int b, int c) {
        largest = a;
        smallest = b;
        count = c;
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}