package leetcode.offer63_maxProfit;

/**
 * 剑指 Offer 63. 股票的最大利润
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int curMin = prices[0];
        int ret = 0;
        for (int i = 1; i < prices.length; i++) {
            curMin = Math.min(prices[i - 1] ,curMin);
            ret = Math.max(prices[i] - curMin, ret);
        }

        return ret;
    }
}
