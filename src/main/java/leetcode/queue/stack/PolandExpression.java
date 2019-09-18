package leetcode.queue.stack;

import java.util.Stack;

public class PolandExpression {

    private int operation(String A, String B, String oper) {
        int a = Integer.valueOf(A);
        int b = Integer.valueOf(B);
        int res = 0;
        switch (oper) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "*":
                res = a * b;
                break;
            case "/":
                res = a / b;
                break;
                default:
                    break;
        }
        return res;
    }

    public int evalRPN(String[] tokens) {
        String operation = "+-*/";
        Stack<String> container = new Stack<>();
        for (String token : tokens) {
            if (container.isEmpty()) {
                container.push(token);
            } else {
                if (operation.contains(token)) {
                    String A = container.pop();
                    String B = container.pop();
                    container.push("" + operation(B, A, token));
                }else {
                    container.push(token);
                }
            }
        }
        return Integer.parseInt(container.pop());
    }

    public static void main(String[] args) {
        System.out.println(new PolandExpression().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
