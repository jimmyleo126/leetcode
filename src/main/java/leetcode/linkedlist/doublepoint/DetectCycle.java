package leetcode.linkedlist.doublepoint;

public class DetectCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        boolean cycle = false;
        int counter;
        ListNode start = null;
        if (head == null) {
            return start;
        }
        ListNode p1, p2;
        p1 = p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                cycle = true;
                p2 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                start = p1;
                break;
            }
        }
        return start;
    }

    public static void main(String[] args) {

    }
}
