import java.util.*;

class Intersection_of_Two_Linked_List {

    // Time Complexity : O(m+n)
    // Space Complexity : O(m)
    static Node Solution1(Node headA, Node headB) {
        HashSet<Node> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    // Time Complexity : O(m+n)
    static Node Solution2(Node headA, Node headB) {
        Node d1 = headA;
        Node d2 = headB;
        while (d1 != d2) {
            d1 = (d1 == null) ? headB : d1.next;
            d2 = (d2 == null) ? headA : d2.next;
        }
        return d1;
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