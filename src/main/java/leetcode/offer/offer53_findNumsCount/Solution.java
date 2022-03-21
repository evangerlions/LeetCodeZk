package leetcode.offer.offer53_findNumsCount;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = findFirst(nums, target, 0, nums.length - 1);
        int end = findLast(nums, target, 0, nums.length - 1);
        if (start == -1 || end == -1) return 0;
        return end - start + 1;
    }

    private int findFirst(int[] nums, int target, int start, int end) {
        if (start > end || start < 0 || end >= nums.length) return -1;

        int middle = (start + end) / 2;

        if (nums[middle] == target) {
            if(middle - 1 < 0 || nums[middle - 1] != target) {
                return middle;
            } else {
                return findFirst(nums, target, start, middle - 1);
            }
        } else if (nums[middle] < target) {
            return findFirst(nums, target, middle + 1, end);
        } else {
            return findFirst(nums, target, start, middle - 1);
        }
    }

    private int findLast(int[] nums, int target, int start, int end) {
        if (start > end || start < 0 || end >= nums.length) return -1;

        int middle = (start + end) / 2;

        if (nums[middle] == target) {
            if (middle + 1 >= nums.length || nums[middle + 1] != target) {
                return middle;
            } else {
                return findLast(nums, target, middle + 1, end);
            }
        } else if (nums[middle] < target) {
            return findLast(nums, target, middle + 1, end);
        } else {
            return findLast(nums, target, start, middle - 1);
        }
    }
}