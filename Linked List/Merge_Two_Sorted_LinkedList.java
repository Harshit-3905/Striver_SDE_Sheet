import java.util.*;

class Merge_Two_Sorted_LinkedList {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node head1 = null;
        Node curr = null;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            if (head1 == null) {
                head1 = new Node(x);
                curr = head1;
            } else {
                Node h = new Node(x);
                curr.next = h;
                curr = curr.next;
            }
        }
        int m = in.nextInt();
        Node head2 = null;
        curr = null;
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            if (head2 == null) {
                head2 = new Node(x);
                curr = head2;
            } else {
                Node h = new Node(x);
                curr.next = h;
                curr = curr.next;
            }
        }
        Node head = Solution(head1, head2);
        curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        in.close();
    }

    // Time Complexity : O(m+n)
    // Space Complexity : O(m+n)
    static Node Solution(Node head1, Node head2) {
        Node head = null;
        Node curr = null;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (head == null) {
                    head = new Node(head1.val);
                    curr = head;
                    head1 = head1.next;
                } else {
                    curr.next = new Node(head1.val);
                    curr = curr.next;
                }
                head1 = head1.next;
            } else {
                if (head == null) {
                    head = new Node(head2.val);
                    curr = head;
                    head2 = head2.next;
                } else {
                    curr.next = new Node(head2.val);
                    curr = curr.next;
                }
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            if (head == null) {
                head = new Node(head1.val);
                curr = head;
                head1 = head1.next;
            } else {
                curr.next = new Node(head1.val);
                curr = curr.next;
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            if (head == null) {
                head = new Node(head2.val);
                curr = head;
                head2 = head2.next;
            } else {
                curr.next = new Node(head2.val);
                curr = curr.next;
            }
            head2 = head2.next;
        }
        return head;
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