package leetcode.offer2.offer2_3_countBins;

/**
 * https://leetcode-cn.com/problems/w3tCBm/submissions/
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 */
public class Solution {
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ret[i] = ret[i & i - 1] + 1;
        }
        return ret;
    }
}
