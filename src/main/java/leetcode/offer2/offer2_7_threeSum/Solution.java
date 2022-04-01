package leetcode.offer2.offer2_7_threeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * https://leetcode-cn.com/problems/1fGaJU/
 * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？请找出所有和为 0 且不重复的三元组。
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length;) {
            twoNums(nums, i, ret);
            int temp = nums[i];
            while(i < nums.length && temp == nums[i]) {
                i++;
            }
        }
        return ret;
    }

    private void twoNums(int[] nums, int i,  List<List<Integer>> ret) {
        int j = i + 1;
        int k = nums.length - 1;

        while(j < k) {
            int sum = nums[j] + nums[k] + nums[i];
            if (sum == 0) {
                ret.add(Arrays.asList(nums[i], nums[j], nums[k]));
                int temp = nums[j];
                while(temp == nums[j] && j < k) {
                    j++;
                }
            } else if (sum < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}