
class Construct_BST_from_Preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode curr = root;
            while (true) {
                if (preorder[i] < curr.val) {
                    if (curr.left != null)
                        curr = curr.left;
                    else {
                        curr.left = new TreeNode(preorder[i]);
                        break;
                    }
                } else {
                    if (curr.right != null)
                        curr = curr.right;
                    else {
                        curr.right = new TreeNode(preorder[i]);
                        break;
                    }
                }
            }
        }
        return root;
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