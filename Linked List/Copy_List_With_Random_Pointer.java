import java.util.*;

class Copy_List_With_Random_Pointer {

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
        Node ans = BruteForce(head1);
        // int ans = Optimised(head1);
        System.out.println(ans);
        in.close();
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    static Node BruteForce(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            Node x = new Node(curr.val);
            map.put(curr, x);
            curr = curr.next;
        }
        curr = head;
        Node ans = map.get(head);
        Node d = ans;
        while (curr != null) {
            d.next = map.get(curr.next);
            d.random = map.get(curr.random);
            d = d.next;
            curr = curr.next;
        }
        return ans;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    static Node Optimised(Node head) {
        Node curr = head;
        while (curr != null) {
            Node y = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = y;
            curr = curr.next.next;
        }
        curr = head;
        Node ans = head.next;
        while (curr != null) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
            curr = curr.next.next;
        }
        Node d = ans;
        while (d != null) {
            d.next = (d.next == null) ? null : d.next.next;
            d = d.next;
        }
        return ans;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    Node(int x) {
        val = x;
        next = null;
        random = null;
    }
}