import java.util.*;

class Serialize_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode p = q.poll();
            if (p != null) {
                ans.append(p.val);
                q.add(p.left);
                q.add(p.right);
            } else {
                ans.append("null");
            }
            ans.append(',');
        }
        return ans.toString();
    }

    public TreeNode deserialize(String data) {
        String w[] = data.split(",");
        if (w[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(w[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while (!q.isEmpty()) {
            TreeNode p = q.poll();
            if (!w[index].equals("null")) {
                p.left = new TreeNode(Integer.parseInt(w[index]));
                q.add(p.left);
            }
            index++;
            if (!w[index].equals("null")) {
                p.right = new TreeNode(Integer.parseInt(w[index]));
                q.add(p.right);
            }
            index++;
        }
        return root;
    }
}
