class Binary_Tree_Maximun_Path_Sum {
    int max_sum;

    public int maxPathSum(Node root) {
        max_sum = Integer.MIN_VALUE;
        helper(root);
        return max_sum;
    }

    int helper(Node root) {
        if (root == null)
            return 0;
        int left_sum = helper(root.left);
        int right_sum = helper(root.right);
        int curr_sum = root.val;
        if (left_sum > 0)
            curr_sum += left_sum;
        if (right_sum > 0)
            curr_sum += right_sum;
        max_sum = Math.max(max_sum, curr_sum);
        return root.val + Math.max(0, Math.max(left_sum, right_sum));
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