package leetcode.linkedlist.classic;

public class OddEvenList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode odd = new ListNode(0);
        ListNode oddCurr = odd;
        ListNode even = new ListNode(0);
        ListNode evenCurr = even;

        ListNode tmp = head;
        int counter = 0;
        while (tmp != null) {
            counter++;
            if (counter % 2 != 0) {
                oddCurr.next = new ListNode(tmp.val);
                oddCurr = oddCurr.next;
            } else {
                evenCurr.next = new ListNode(tmp.val);
                evenCurr = evenCurr.next;
            }
            tmp = tmp.next;
        }
        oddCurr.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode root = head;
        root = root.next = new ListNode(2);
        root = root.next = new ListNode(3);
        root = root.next = new ListNode(4);
        root = root.next = new ListNode(5);
        new OddEvenList().oddEvenList(head);
    }
}
