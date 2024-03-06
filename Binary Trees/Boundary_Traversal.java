import java.util.ArrayList;

class Boundary_Traversal {
    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) {
            return ans;
        }
        printLeft(node, ans);
        printLeaf(node, ans);
        printRight(node.right, ans);

        return ans;
    }

    public static void printRight(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        if (node.right != null)
            printRight(node.right, ans);
        else
            printRight(node.left, ans);
        ans.add(node.data);
    }

    public static void printLeaf(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;
        if (node.left == null & node.right == null) {
            ans.add(node.data);
            return;
        }
        printLeaf(node.left, ans);
        printLeaf(node.right, ans);
    }

    public static void printLeft(Node node, ArrayList<Integer> ans) {
        if (node == null || (node.left == null & node.right == null))
            return;
        ans.add(node.data);
        if (node.left != null)
            printLeft(node.left, ans);
        else if (ans.size() > 1)
            printLeft(node.right, ans);
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}