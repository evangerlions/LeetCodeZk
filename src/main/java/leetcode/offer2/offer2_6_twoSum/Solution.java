package leetcode.offer2.offer2_6_twoSum;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * https://leetcode-cn.com/problems/kLl5u1/
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }
}
