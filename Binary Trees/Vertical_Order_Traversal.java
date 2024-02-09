import java.util.*;

class Vertical_Order_Traversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        PriorityQueue<Trie> q = new PriorityQueue<>((x, y) -> {
            if (x.row == y.row) {
                if (x.col == y.col)
                    return x.node.val - y.node.val;
                else
                    return x.col - y.col;
            } else
                return x.row - y.row;
        });
        q.add(new Trie(root, 0, 0));
        while (!q.isEmpty()) {
            int x = q.size();
            for (int i = 0; i < x; i++) {
                Trie p = q.poll();
                if (p.node.left != null)
                    q.add(new Trie(p.node.left, p.row + 1, p.col - 1));
                if (p.node.right != null)
                    q.add(new Trie(p.node.right, p.row + 1, p.col + 1));
                if (map.containsKey(p.col))
                    map.get(p.col).add(p.node.val);
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(p.node.val);
                    map.put(p.col, list);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> x : map.entrySet()) {
            ans.add(x.getValue());
        }
        return ans;
    }

    class Trie {
        TreeNode node;
        int row;
        int col;

        Trie(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}