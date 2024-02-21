import java.util.*;

class BSTIterator {
    List<Integer> list;
    int i;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        i = -1;
    }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }

    public int next() {
        i++;
        return list.get(i);
    }

    public boolean hasNext() {
        if (i == list.size() - 1)
            return false;
        return true;
    }
}
