package leetcode.offer2.offer2_38_dailyTemperatures;

import java.util.Stack;

/**
 * 剑指 Offer II 038. 每日温度
 * https://leetcode.cn/problems/iIQa4I/
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ret = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int todayTemp = temperatures[i];
            if (stack.isEmpty() || temperatures[stack.peek()] >= todayTemp) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    if (temperatures[stack.peek()] < todayTemp) {
                        int index = stack.pop();
                        ret[index] = i - index;
                    } else {
                        break;
                    }
                }
                stack.push(i);
            }
        }

        return ret;
    }
}