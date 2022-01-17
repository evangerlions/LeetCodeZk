package leetcode.offer53p2_missingNumberIn0toNsub1;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 */
class Solution {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) return -1;

        return findCore(nums, 0, nums.length - 1);
    }

    private int findCore(int[] nums, int start, int end) {
        if (start > end) {
            return end + 1;
        }

        if (start < 0 || end >= nums.length) return -1;

        int index = (start + end) / 2;
        int middle = nums[index];
        if (middle == index) {
            return findCore(nums, index + 1, end);
        } else if (index - 1 < 0 || nums[index - 1] == index - 1) {
            return index;
        } else {
            return findCore(nums, start, index - 1);
        }
    }
}