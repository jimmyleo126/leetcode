package leetcode.queue.stack;

import java.util.Stack;

public class MinStack {

    int MIN = Integer.MAX_VALUE;

    private Stack<Integer> stack = new Stack<>();

    public MinStack(){

    }

    public void push(int x) {
        if (x <= MIN) {
            stack.push(MIN);
            MIN = x;
        }
        stack.push(x);
    }

    public void pop() {
        int p = stack.pop();
        if (p <= MIN) {
            MIN = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return MIN;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(8);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(1);
    }
}
