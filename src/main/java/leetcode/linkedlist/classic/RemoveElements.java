package leetcode.linkedlist.classic;

public class RemoveElements {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 为空
        if (head == null) {
            return null;
        }
        // 当不为空 且链表值等于给定值时
        while (head != null && head.val == val) {
            // 位移一位
            head = head.next;
        }

        ListNode node = head;
        if (node == null) {
            return null;
        }

        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode root = head;
        /*root = root.next = new ListNode(2);
        root = root.next = new ListNode(3);
        root = root.next = new ListNode(4);
        root = root.next = new ListNode(5);
        root = root.next = new ListNode(6);*/
        new RemoveElements().removeElements(head, 1);
    }
}
