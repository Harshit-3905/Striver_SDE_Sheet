import java.util.Scanner;

class Middle_of_Linked_List {
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
        // int ans = Brute_Force(head1);
        int ans = Optimised(head1);
        System.out.println(ans);
        in.close();
    }

    static int Brute_Force(Node head) {
        Node curr = head;
        int n = 0;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        n /= 2;
        curr = head;
        while (n-- > 0)
            curr = curr.next;
        return curr.val;
    }

    static int Optimised(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
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