package leetcode.offer56_findNumsInArray;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Solution {

    public int[] singleNumbers(int[] nums) {

        if (nums.length <= 2) return nums;

        int andRet = nums[0];
        for (int i = 1; i < nums.length; i++) {
            andRet ^= nums[i];
        }

        int first1Bit = findFirst1Bit(andRet);

        Integer ret1 = null;
        Integer ret2 = null;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (is1InBit(n, first1Bit)) {
                if (ret1 == null) { ret1 = n; }
                else {
                    ret1 ^= n;
                }
            } else {
                if (ret2 == null) { ret2 = n; }
                else {
                    ret2 ^= n;
                }
            }
        }

        return new int[]{ret1, ret2};
    }

    private int findFirst1Bit(int n) {
        int index = 0;

        while((n & 1) != 1) {
            n = n >> 1;
            index++;
        }
        return index;
    }

    private boolean is1InBit(int n, int bitIndex) {
        for (int i = 0; i < bitIndex; i++) {
            n = n >> 1;
        }
        return (n & 1) == 1;
    }
}
