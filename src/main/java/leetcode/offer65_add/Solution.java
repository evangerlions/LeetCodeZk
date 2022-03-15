package leetcode.offer65_add;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 */
public class Solution {
    public int add(int a, int b) {
        int ret = a ^ b;
        int carry = (a & b) << 1;

        while(carry != 0) {
            int oldRet = ret;
            ret = ret ^ carry;
            carry = (oldRet & carry) << 1;
        }
        return ret;
    }
}
