import java.util.*;

class Postorder_Traversal {
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
        Stack<Node> st = new Stack<>();
        while (curr != null || !st.isEmpty()) {

            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                Node temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    list.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        list.add(temp.val);
                    }
                } else
                    curr = temp;
            }
        }
    }

    // Recursion
    static void Solution2(Node root, List<Integer> list) {
        if (root != null) {
            Solution2(root.left, list);
            Solution2(root.right, list);
            list.add(root.val);
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