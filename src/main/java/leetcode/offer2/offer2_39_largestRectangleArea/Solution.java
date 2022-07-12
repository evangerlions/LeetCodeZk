package leetcode.offer2.offer2_39_largestRectangleArea;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer II 039. 直方图最大矩形面积
 * https://leetcode.cn/problems/0ynMMM/submissions/
 */
class Solution {
    int[] heights;
    public int largestRectangleArea(int[] heights) {
        this.heights = heights;
        int[] firstLowerRectInLeft = new int[heights.length];
        int[] firstLowerRectInRight = new int[heights.length];
        Arrays.fill(firstLowerRectInLeft, -1);
        Arrays.fill(firstLowerRectInRight, heights.length);
        Stack<Integer> stack = new Stack<Integer>();
        fillMinIndex(stack, firstLowerRectInRight, false);
        fillMinIndex(stack, firstLowerRectInLeft, true);
        // println(firstLowerRectInLeft);
        // println(firstLowerRectInRight);

        int ret = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = firstLowerRectInLeft[i] + 1;
            int right = firstLowerRectInRight[i] - 1;
            int cur = (right - left + 1) * heights[i];
            ret = Math.max(cur, ret);
        }
        return ret;
    }

    private void fillMinIndex(Stack<Integer> stack, int[] array, boolean isReverse) {
        for (int i = 0; i < heights.length; i++) {
            int ci = isReverse ? heights.length - 1 - i : i;
            int cur = heights[ci];
            if (stack.isEmpty() || cur == heights[stack.peek()] || cur > heights[stack.peek()]) {
                stack.push(ci);
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                    array[stack.pop()] = ci;
                }
                stack.push(ci);
            }
        }
    }

    private void println(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}