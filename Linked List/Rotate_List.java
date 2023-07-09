import java.util.*;

class Rotate_List {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
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
        Node ans = Solution(head1, k);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        in.close();
    }

    static Node Solution(Node head, int k) {
        Node curr = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        k = k % n;
        Node newhead = head;
        while (k-- >= 0)
            newhead = newhead.next;
        curr = newhead;
        while (curr.next != null)
            curr = curr.next;
        curr.next = head;
        while (curr.next != newhead)
            curr = curr.next;
        curr.next = null;
        return newhead;
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