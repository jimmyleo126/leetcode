package leetcode.linkedlist.classic;

public class Palindrome {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode l = head;
        ListNode newH = null;
        ListNode node = head;
        ListNode temp = head;
        // 得到链表的长度
        int len = 0;
        while (l != null) {
            len++;
            l = l.next;
        }
        // 倒置链表，在倒置过程中，newH是最后一个节点，也是倒置后链表的初始节点。temp指向空，而改提
        for (int i = 0; i < len / 2; i++) {
            temp = node.next;
            node.next = newH;
            newH = node;
            node = temp;
        }
        // 如果奇数则需要让后续链表前进一格
        if ()


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode root = head;
        root = root.next = new ListNode(2);
        root = root.next = new ListNode(3);
        root = root.next = new ListNode(4);
        root = root.next = new ListNode(5);
        new Palindrome().isPalindrome(head);
    }
}
