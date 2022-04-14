package leetcode.offer2.offer2_11_findMaxLength;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int sum = 0;

        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, -1);
        int i = 0;
        for (int num : nums) {
            int n = (num == 0 ? -1 : 1);
            sum += n;
            if (sumToCount.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumToCount.get(sum));
            } else {
                sumToCount.put(sum, i);
            }
            i++;
        }
        return maxLen;
    }
}
