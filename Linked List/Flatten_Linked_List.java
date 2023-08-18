class Flatten_Linked_List {
    Node MergeTwoList(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = MergeTwoList(a.bottom, b);
        } else {
            result = b;
            result.bottom = MergeTwoList(a, b.bottom);
        }
        result.next = null;
        return result;
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        root.next = flatten(root.next);
        root = MergeTwoList(root, root.next);
        return root;
    }
}

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d) {
        data = d;
        next = null;
        bottom = null;
    }
}