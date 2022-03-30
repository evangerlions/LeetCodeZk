package leetcode.offer2.offer2_88_minCostClimbingStairs;

/**
 * 剑指 Offer II 088. 爬楼梯的最少成本
 * https://leetcode-cn.com/problems/GzCJIP/
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[2];
        int sum = 0;
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            sum = Math.min(dp[1], dp[0]) + cost[i];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return Math.min(dp[0], dp[1]);
    }
}
