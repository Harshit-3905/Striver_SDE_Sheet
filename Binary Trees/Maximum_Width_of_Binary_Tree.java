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
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        int max = 0;
        while (!q.isEmpty()) {
            int x = q.size();
            int a = 0, b = 0;
            for (int i = 0; i < x; i++) {
                Pair p = q.poll();
                Node curr = p.x;
                if (i == 0)
                    a = p.y;
                if (i == x - 1)
                    b = p.y;
                if (curr.left != null)
                    q.add(new Pair(curr.left, 2 * p.y));
                if (curr.right != null)
                    q.add(new Pair(curr.right, 2 * p.y + 1));

            }
            max = Math.max(max, b - a + 1);
        }
        return max;
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

class Pair {
    Node x;
    int y;

    Pair(Node x, int y) {
        this.x = x;
        this.y = y;
    }
}