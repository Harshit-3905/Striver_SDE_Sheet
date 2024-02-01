import java.util.*;

class Reverse_Linked_List {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node head = null;
        Node curr = null;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (head == null) {
                head = new Node(x);
                curr = head;
            } else {
                Node h = new Node(x);
                curr.next = h;
                curr = curr.next;
            }
        }
        // Node ans1 = Iterative(head);
        Node ans2 = Recursive(head);
        while (ans2 != null) {
            System.out.print(ans2.val + " ");
            ans2 = ans2.next;
        }
        in.close();
    }

    static Node Iterative(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node x = curr.next;
            curr.next = prev;
            if (prev == head)
                prev.next = null;
            prev = curr;
            curr = x;
        }
        return prev;
    }

    static Node Recursive(Node head) {
        if (head == null || head.next == null)
            return head;
        Node ans = head;
        ans = Recursive(head.next);
        Node curr = ans;
        while (curr.next != null)
            curr = curr.next;
        curr.next = head;
        head.next = null;
        return ans;
    }
}

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}