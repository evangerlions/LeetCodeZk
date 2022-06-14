package leetcode.offer2.offer2_36_evalRPN;

import java.util.Stack;

/**
 * 剑指 Offer II 036. 后缀表达式
 * https://leetcode.cn/problems/8Zf90G/
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+")) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(a + b);
            } else if (s.equals("-")) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b - a);
            } else if (s.equals("*")) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(a * b);
            } else if (s.equals("/")) {
                int a = nums.pop();
                int b = nums.pop();
                nums.push(b / a);
            } else {
                nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }
}