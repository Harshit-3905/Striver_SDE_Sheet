import java.util.*;

class Zig_Zag_Traversal {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        List<List<Integer>> ans = Solution(root);
        for (List<Integer> x : ans) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
        in.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static List<List<Integer>> Solution(Node root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (root == null)
            return list;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean flag = false;
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
            if (flag)
                Collections.reverse(l);
            list.add(l);
            flag = !flag;
        }
        return list;
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