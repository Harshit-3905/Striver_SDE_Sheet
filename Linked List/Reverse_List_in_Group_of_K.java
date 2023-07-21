import java.util.*;

class Reverse_List_in_Group_of_K {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
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
        // Node ans1 = Solution1(head, k);
        Node ans2 = Solution2(head, k);
        curr = ans2;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        in.close();
    }

    // Stack Solution
    static Node Solution1(Node head, int k) {
        if (head == null)
            return head;
        int n = 1;
        Node curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        if (n < k)
            return head;
        Stack<Node> s = new Stack<>();
        Node head1 = null;
        Node d = null;
        curr = head;
        int i = 1;
        while (i + k <= n && curr != null) {
            int x = k;
            while (x-- > 0 && curr != null) {
                s.push(curr);
                curr = curr.next;
            }
            while (!s.isEmpty()) {
                if (head1 == null) {
                    head1 = s.pop();
                    d = head1;
                } else {
                    d.next = s.pop();
                    d = d.next;
                }
            }
            i += k;
        }
        d.next = curr;
        return head1;
    }

    // Iterative Solution
    static Node Solution2(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node pre = dummy, cur = dummy, nex = dummy;
        int count = 0;

        while (cur.next != null) {
            count++;
            cur = cur.next;
        }

        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
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