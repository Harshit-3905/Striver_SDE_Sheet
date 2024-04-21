import java.util.*;

class Two_Sum_IV {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator it = new BSTIterator(root);
        int x = it.next();
        int y = it.before();
        while (x != y) {
            if (x + y == k)
                return true;
            else if (x + y < k)
                x = it.next();
            else
                y = it.before();
        }
        return false;
    }
}

class BSTIterator {
    Stack<TreeNode> s = new Stack<>();
    Stack<TreeNode> e = new Stack<>();

    BSTIterator(TreeNode root) {
        TreeNode x = root;
        while (x != null) {
            s.push(x);
            x = x.left;
        }
        while (root != null) {
            e.push(root);
            root = root.right;
        }
    }

    int next() {
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

    int before() {
        TreeNode p = e.pop();
        int x = p.val;
        if (p.left != null) {
            p = p.left;
            while (p != null) {
                e.push(p);
                p = p.right;
            }
        }
        return x;
    }
}