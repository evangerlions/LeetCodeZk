package leetcode.offer2.offer2_09_numSubarrayProductLessThanK;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int p1 = 0;
        int p2 = 0;

        int count = 0;
        int product = nums[0];
        while (p2 < nums.length) {
            if (product >= k) {
                product = product / nums[p1];
                p1++;
                p2 = Math.max(p2, p1);
            } else {
                count += p2 - p1 + 1;
                p2++;
                if (p2 < nums.length)
                    product *= nums[p2];
            }
        }
        return count;
    }
}
