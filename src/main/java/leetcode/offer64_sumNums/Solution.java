package leetcode.offer64_sumNums;

/**
 * 剑指 Offer 64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 */
public class Solution {
    public int sumNums(int n) {
        return multi(1 + n, n) >> 1;
    }


    private int multi(int a, int b) {
        int ans = 0;
        int factor = 1;
        for (; b != 0; b = b >> 1) {
            ans += (b & 1) * a * factor;
            factor = factor << 1;
        }
        return ans;
    }
}
