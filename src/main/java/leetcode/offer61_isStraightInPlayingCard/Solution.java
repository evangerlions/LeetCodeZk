package leetcode.offer61_isStraightInPlayingCard;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        int joker = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v == 0) {
                joker++;
            } else if (i + 1 < nums.length && v == nums[i+1]) {
                return false;
            }
        }
        return nums[nums.length - 1] - nums[joker] < 5;
    }
}
