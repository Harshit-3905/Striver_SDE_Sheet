import java.util.*;

class Inorder_Traversal {
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
        Stack<Node> s = new Stack<>();
        Node curr = root;
        while (true) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if (s.isEmpty())
                    break;
                curr = s.pop();
                list.add(curr.val);
                curr = curr.right;
            }
        }
    }

    // Recursion
    static void Solution2(Node root, List<Integer> list) {
        if (root != null) {
            Solution2(root.left, list);
            list.add(root.val);
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