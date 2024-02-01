import java.util.*;

class Palindrome_Linked_List {
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
        boolean ans1 = Solution1(head);
        // boolean ans2 = Solution2(head);
        System.out.println(ans1);
        in.close();
    }

    static boolean Solution1(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> s = new Stack<>();
        Node curr = slow;
        while (curr != null) {
            s.push(curr);
            curr = curr.next;
        }
        curr = head;
        while (!s.isEmpty()) {
            if (curr.val != s.peek().val)
                return false;
            curr = curr.next;
            s.pop();
        }
        return true;
    }

    static boolean Solution2(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node curr = reverse(slow);
        while (curr != null) {
            if (curr.val != head.val)
                return false;
            head = head.next;
            curr = curr.next;
        }
        return true;
    }

    static Node reverse(Node head) {
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
}

class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
        next = null;
    }
}