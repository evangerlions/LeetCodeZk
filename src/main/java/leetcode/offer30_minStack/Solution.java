package leetcode.offer30_minStack;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
class MinStack {

    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> minS = new Stack<Integer>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        s.push(x);
        if (minS.isEmpty() || x < minS.peek()) {
            minS.push(x);
        } else {
            minS.push(minS.peek());
        }
    }

    public void pop() {
        s.pop();
        minS.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */