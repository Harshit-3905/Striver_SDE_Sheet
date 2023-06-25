import java.util.Scanner;

class Delete_Node_From_Given_Node {
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
        delete(head1);
        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
        in.close();
    }

    static void delete(Node head) {
        if (head.next == null)
            head = null;
        else {
            head.val = head.next.val;
            head.next = head.next.next;
        }
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