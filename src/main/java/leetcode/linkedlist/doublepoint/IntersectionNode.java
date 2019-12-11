package leetcode.linkedlist.doublepoint;

public class IntersectionNode {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode A = headA;
        ListNode B = headB;

        int lenA = 0;
        int lenB = 0;

        while (A != null) {
            lenA++;
            A = A.next;
        }
        while (B != null) {
            lenB++;
            B = B.next;
        }
        A = headA;
        B = headB;
        if (lenA > lenB) {
            int step = lenA - lenB;
            for (int i = 0; i < step; i++) {
                A = A.next;
            }
        } else {
            int step = lenB - lenA;
            for (int i = 0; i < step; i++) {
                B = B.next;
            }
        }

        while (A != B) {
            A = A.next;
            B = B.next;
        }
        return A;
    }

    public static void main(String[] args) {

    }
}
