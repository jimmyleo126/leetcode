package leetcode.linkedlist;

public class MyLinkedList {

    private Node head;

    private int size;

    // Definition for singly-linked list.
    public class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            size++;
            return;
        }
        Node x = head;
        head = new Node(val);
        head.next = x;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            size++;
            return;
        }
        Node x = head;
        while (x.next != null) {
            x = x.next;
        }
        x.next = new Node(val);
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if ( index > size){
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node x = head;
        for (int i = 0; i < index - 1; i++) {
            x = x.next;
        }
        Node next = x.next;
        x.next = new Node(val);
        x.next.next = next;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node x = head;
        for (int i = 0; i < index - 1; i++) {
            x = x.next;
        }
        x.next = x.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(3));
    }
}
