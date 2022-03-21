package leetcode.offer.offer31_validateStackSequences;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<Integer>();

        if (pushed.length != popped.length) return false;
        if (pushed.length == 0) return true;

        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            while (s.isEmpty() || s.peek() != popped[i]) {
                if (j >= pushed.length) return false;
                s.push(pushed[j]);
                j++;
            }
            s.pop();
        }
        return true;
    }
}