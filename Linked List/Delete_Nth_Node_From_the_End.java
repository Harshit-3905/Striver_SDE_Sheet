import java.util.*;

class Delete_Nth_Node_From_the_End {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Node head = new Node(in.nextInt());
        Node temp = head;
        for (int i = 1; i < n; i++) {
            temp.next = new Node(in.nextInt());
            temp = temp.next;
        }
        // Solution1(head, k);
        Solution2(head, k);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        in.close();
    }

    // Time Complexity : O(n)
    static void Solution1(Node head, int k) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (k > count)
            return;
        if (k == count) {
            head = head.next;
            return;
        }
        temp = head;
        for (int i = 0; i < count - k - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    // Time Complexity : O(n)
    static void Solution2(Node head, int k) {
        Node slow = head;
        Node fast = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        if (k != 0)
            return;
        if (fast == null) {
            head = head.next;
            return;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
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