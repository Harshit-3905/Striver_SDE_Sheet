import java.util.*;

class Kth_Smallest_Element_in_BST {

    // Iterative
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int result = 0;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                k--;
                if (k == 0) {
                    result = t.val;
                    break;
                }
                p = t.right;
            }
        }

        return result;
    }

    // Recursive
    int res = -1;

    public int kthSmallest1(TreeNode root, int k) {
        helper(root, k);

        return res;
    }

    public int helper(TreeNode root, int k) {
        if (root == null)
            return 0;

        int left = 1 + helper(root.left, k);

        if (left == k) {
            res = root.val;
        }

        return left + helper(root.right, k - left);
    }
}