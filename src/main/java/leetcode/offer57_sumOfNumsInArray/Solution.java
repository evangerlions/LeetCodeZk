package leetcode.offer57_sumOfNumsInArray;

/**
 * 剑指 Offer 57. 和为s的两个数字
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        if (len <= 1) return new int[0];

        int i = 0;
        int j = len - 1;
        while(i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                break;
            }
        }

        if (nums[i] + nums[j] != target) {
            return new int[0];
        }
        return new int[]{nums[i], nums[j]};
    }
}
