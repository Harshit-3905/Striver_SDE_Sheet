import java.util.*;

class Preorder_Traversal {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> list = new ArrayList<>();
        Solution1(root, list);
        // Solution2(root, list);
        for (int x : list)
            System.out.print(x + " ");
        in.close();
    }

    // Stack
    static void Solution1(Node root, List<Integer> list) {
        Node curr = root;
        if (curr == null)
            return;
        Stack<Node> s = new Stack<>();
        s.push(curr);
        while (!s.isEmpty()) {
            Node topNode = s.peek();
            list.add(topNode.val);
            s.pop();
            if (topNode.right != null)
                s.push(topNode.right);
            if (topNode.left != null)
                s.push(topNode.left);
        }
    }

    // Recursion
    static void Solution2(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            Solution2(root.left, list);
            Solution2(root.right, list);
        }
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