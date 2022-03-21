package leetcode.offer.offer59_maxValueInSlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> queue = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            // pop over window element
            if (!queue.isEmpty() && i - queue.peekFirst() >= k) {
                queue.pollFirst();
            }

            // insert appropriate position
            while(!queue.isEmpty() && nums[queue.peekLast()] <= v) {
                queue.pollLast();
            }
            queue.addLast(i);

            if (i >= k - 1) {
                ret[i - k + 1] = nums[queue.peekFirst()];
            }
            // for (Integer n : queue) {
            //     System.out.print(nums[n] + " ");
            // }
            // System.out.println();
        }
        return ret;
    }
}
