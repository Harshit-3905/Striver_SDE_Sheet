import java.util.*;

class Right_View_of_Binary_Tree {
    static List<Integer> ans;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.left.right = new Node(15);
        root.left.left = new Node(15);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        ans = new ArrayList<>();
        // Solution1(root, 0);
        Solution2(root);
        for (int x : ans)
            System.out.print(x + " ");
        in.close();
    }

    // Time Complexity :O(n)
    // Space Complexity :O(H)
    static void Solution1(Node root, int level) {
        if (root == null)
            return;
        if (level == ans.size())
            ans.add(root.val);
        Solution1(root.right, level + 1);
        Solution1(root.left, level + 1);
    }

    // Time Complexity :O(n)
    // Space Complexity :O(H)
    static void Solution2(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int x = q.size();
            for (int i = 0; i < x; i++) {
                Node p = q.poll();
                if (i == x - 1)
                    ans.add(p.val);
                if (p.left != null)
                    q.add(p.left);
                if (p.right != null)
                    q.add(p.right);
            }
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
