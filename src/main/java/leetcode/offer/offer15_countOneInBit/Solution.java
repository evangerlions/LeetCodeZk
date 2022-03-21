package leetcode.offer.offer15_countOneInBit;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        int flag = 1;
        while(flag != 0) {
            if ((n & flag) != 0) {
                sum++;
            }
            flag = flag << 1;
        }
        return sum;
    }
}
