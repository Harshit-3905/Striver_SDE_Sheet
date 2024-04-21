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

class BSTIterator1 {
    Stack<TreeNode> s = new Stack<>();

    public BSTIterator1(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode p = s.pop();
        int x = p.val;
        if (p.right != null) {
            p = p.right;
            while (p != null) {
                s.push(p);
                p = p.left;
            }
        }
        return x;
    }

    public boolean hasNext() {
        return !s.isEmpty();
    }
}
