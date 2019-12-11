package leetcode.linkedlist.doublepoint;

import leetcode.linkedlist.MyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HasCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        if (head == null) {
            return false;
        }
        ListNode x = head.next;
        while (x != null) {
            if (listNodes.contains(x)) {
                System.out.println(listNodes.indexOf(x));
                return true;
            }
            listNodes.add(x);
            x = x.next;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
