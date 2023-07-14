import java.util.*;

class Maximum_Width_of_Binary_Tree {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.left.right = new Node(15);
        root.left.left = new Node(15);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(Solution(root));
        in.close();
    }

    // Time Complexity :O(n)
    // Space Complexity :O(n)
    static int Solution(Node root) {
        int ans = 0;
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int x = q.size();
            ArrayList<Integer> l = new ArrayList<>();
            for (int i = 0; i < x; i++) {

                Node curr = q.poll();
                l.add(curr.val);
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            ans = Math.max(ans, q.size());
        }
        return ans;
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