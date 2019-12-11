package leetcode.linkedlist.doublepoint;

public class RemoveNthFromEnd {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        while (n-- != 0) {
            first = first.next;
        }
        if (first != null) {
            return head.next;
        }
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
       /* ListNode root = head;
        root = root.next = new ListNode(2);
        root = root.next = new ListNode(3);
        root = root.next = new ListNode(4);
        root = root.next = new ListNode(5);*/
        new RemoveNthFromEnd().removeNthFromEnd(head, 1);
    }
}
