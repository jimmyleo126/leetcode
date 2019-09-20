package leetcode.queue;

import java.util.Stack;

public class StackToQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /** Initialize your data structure here. */
    public StackToQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
        StackToQueue obj = new StackToQueue();
        obj.push(7);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(1);
    }

}
