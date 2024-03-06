import java.util.*;

class Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int x = q.size();
            for (int i = 0; i < x; i++) {
                Node curr = q.poll();
                if (i != x - 1)
                    curr.next = q.peek();
                else
                    curr.next = null;
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return root;
    }

    public void connect2(Node root) {
        Node dummyHead = new Node(0);
        Node pre = dummyHead;
        while (root != null) {
            if (root.left != null) {
                pre.next = root.left;
                pre = pre.next;
            }
            if (root.right != null) {
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if (root == null) {
                pre = dummyHead;
                root = dummyHead.next;
                dummyHead.next = null;
            }
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}