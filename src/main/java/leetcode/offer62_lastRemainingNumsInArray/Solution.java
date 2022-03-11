package leetcode.offer62_lastRemainingNumsInArray;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class Solution {
    public int lastRemaining(int n, int m) {
        int ret = 0;
        for (int i = 2; i <= n; i++) {
            ret = (ret + m) % i;
        }
        return ret;
    }
}
