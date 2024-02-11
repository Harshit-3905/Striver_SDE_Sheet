import java.util.*;

class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(preorder, 0, inorder, 0, inorder.length - 1, map);
    }

    TreeNode helper(int preorder[], int index, int inorder[], int low, int high, HashMap<Integer, Integer> map) {
        System.out.println(index + " " + low + " " + high);
        int x = preorder[index];
        TreeNode root = new TreeNode(x);
        int mid = map.get(x);
        if (low <= mid - 1)
            root.left = helper(preorder, index + 1, inorder, low, mid - 1, map);
        if (mid + 1 <= high)
            root.right = helper(preorder, index + (mid - low) + 1, inorder, mid + 1, high, map);
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