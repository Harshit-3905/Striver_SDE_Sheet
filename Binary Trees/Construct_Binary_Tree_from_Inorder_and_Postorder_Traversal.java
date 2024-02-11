import java.util.*;

class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(postorder, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    TreeNode helper(int postorder[], int index, int inorder[], int low, int high, HashMap<Integer, Integer> map) {
        int x = postorder[index];
        TreeNode root = new TreeNode(x);
        int mid = map.get(x);
        if (low <= mid - 1)
            root.left = helper(postorder, index - (high - mid + 1), inorder, low, mid - 1, map);
        if (mid + 1 <= high)
            root.right = helper(postorder, index - 1, inorder, mid + 1, high, map);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}