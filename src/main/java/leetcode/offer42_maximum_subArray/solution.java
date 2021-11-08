package leetcode.offer42_maximum_subArray;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 剑指 Offer 42. 连续子数组的最大和
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                curMax += nums[0];
                max = Math.max(curMax, max);
                continue;
            }

            if (curMax > 0) {
                curMax += nums[i];
            } else {
                curMax = nums[i];
            }

            max = Math.max(curMax, max);
        }

        return max;
    }
}