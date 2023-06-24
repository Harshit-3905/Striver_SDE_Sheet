import java.util.Scanner;

class Add_Two_Numbers {
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
        Node ans = add_Two_Numbers(head1, head2);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
        in.close();
    }

    static Node add_Two_Numbers(Node head1, Node head2) {
        Node head = null;
        Node curr = head;
        Node i = head1;
        Node j = head2;
        int carry = 0;
        while (i != null && j != null) {
            int y = i.val + j.val + carry;
            carry = 0;
            if (y > 9) {
                carry = 1;
                y %= 10;
            }
            Node x = new Node(y);
            if (head == null) {
                head = x;
                curr = head;
            } else {
                curr.next = x;
                curr = curr.next;
            }
            i = i.next;
            j = j.next;
        }
        while (i != null) {
            int y = i.val + carry;
            carry = 0;
            if (y > 9) {
                carry = 1;
                y %= 10;
            }
            Node x = new Node(y);
            if (head == null) {
                head = x;
                curr = head;
            } else {
                curr.next = x;
                curr = curr.next;
            }
            i = i.next;
        }
        while (j != null) {
            int y = j.val + carry;
            carry = 0;
            if (y > 9) {
                carry = 1;
                y %= 10;
            }
            Node x = new Node(y);
            if (head == null) {
                head = x;
                curr = head;
            } else {
                curr.next = x;
                curr = curr.next;
            }
            j = j.next;
        }
        if (carry == 1) {
            Node x = new Node(1);
            curr.next = x;
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