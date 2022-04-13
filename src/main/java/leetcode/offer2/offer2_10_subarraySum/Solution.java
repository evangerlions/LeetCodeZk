package leetcode.offer2.offer2_10_subarraySum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;

            count += sumToCount.getOrDefault(sum - k, 0); ;
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
