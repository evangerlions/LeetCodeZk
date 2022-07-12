package leetcode.offer2.offer2_39_largestRectangleArea;

import java.util.Arrays;
import java.util.Stack;

class Solution_Opt {
    int[] heights;

    public int largestRectangleArea(int[] heights) {
        this.heights = heights;
        int[] firstLowerRectInLeft = new int[heights.length];
        int[] firstLowerRectInRight = new int[heights.length];
        Arrays.fill(firstLowerRectInLeft, -1);
        Arrays.fill(firstLowerRectInRight, heights.length);
        Stack<Integer> stack = new Stack<Integer>();
        fillMinIndex(stack, firstLowerRectInLeft, firstLowerRectInRight);
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

    private void fillMinIndex(Stack<Integer> stack, int[] left, int[] right) {
        for (int i = 0; i < heights.length; i++) {
            int cur = heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    }

    private void println(int[] array) {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}