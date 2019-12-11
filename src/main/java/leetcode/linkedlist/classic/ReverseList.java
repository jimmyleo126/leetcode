package leetcode.linkedlist.classic;

import java.util.List;

public class ReverseList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode nodePrev = null;
        ListNode node = head;
        ListNode nodeNext = null;
        while (node != null) {
            nodeNext = node.next;
            node.next = nodePrev;
            nodePrev = node;
            node = nodeNext;
        }
        return nodePrev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode root = head;
        root = root.next = new ListNode(2);
        root = root.next = new ListNode(3);
        root = root.next = new ListNode(4);
        root = root.next = new ListNode(5);
        new ReverseList().reverseList(head);
    }
}
