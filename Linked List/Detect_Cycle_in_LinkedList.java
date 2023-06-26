import java.util.*;

class Detect_Cycle_in_LinkedList {
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
        System.out.println(Brute_Force(head));
        System.out.println(Optimised(head));
        in.close();
    }

    // Time Complwxity : O(n)
    // Space Complwxity : O(n)
    static boolean Brute_Force(Node head) {
        HashSet<Node> set = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (set.contains(curr))
                return true;
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    // Time Complwxity : O(n)
    static boolean Optimised(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
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