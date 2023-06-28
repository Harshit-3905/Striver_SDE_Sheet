import java.util.*;

class Detect_Cycle_in_LinkedList2 {
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
        in.close();
    }

    // Time Complwxity : O(n)
    // Space Complwxity : O(n)
    static Node Brute_Force(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (set.contains(curr))
                break;
            set.add(curr);
            curr = curr.next;
        }
        return curr;
    }

    // Time Complwxity : O(n)
    static Node Optimised(Node head) {
        if (head == null)
            return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast)
            return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next != null)
            return slow;
        return null;
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