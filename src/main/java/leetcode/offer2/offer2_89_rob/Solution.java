package leetcode.offer2.offer2_89_rob;

/**
 * 剑指 Offer II 089. 房屋偷盗
 * https://leetcode-cn.com/problems/Gu0c2T/
 *
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组 nums，请计算不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int cur = 0;
        for (int i = 2; i < len; i++) {
            cur = Math.max(dp[0] + nums[i], dp[1]);

            dp[0] = dp[1];
            dp[1] = cur;
        }

        return Math.max(dp[0], dp[1]);
    }
}
