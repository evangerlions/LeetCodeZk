package leetcode.offer.offer30_minStack;

import java.util.Stack;

/** 只用一个 stack 实现最小栈 */
public class MinStack_SingleStack {

    private static class MinStackEntry {
        int min;
        int val;

        MinStackEntry(int min, int val) {
            this.min = min;
            this.val = val;
        }
    }

    private Stack<MinStackEntry> stack = new Stack<>();

    public MinStack_SingleStack() {

    }

    public void push(int val) {
        int min = stack.isEmpty() ? val : Math.min(stack.peek().min, val);
        stack.push(new MinStackEntry(min, val));
    }

    public void pop() {
        if (stack.isEmpty()) return;
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) return 0;
        return stack.peek().val;
    }

    public int getMin() {
        if (stack.isEmpty()) return 0;
        return stack.peek().min;
    }
}
