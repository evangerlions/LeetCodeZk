package leetcode.offer2.offer2_4_singleNumber;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * https://leetcode-cn.com/problems/WGki4K/
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int ret = 0;
        int len = 32;
        for (int i = 0; i < len; i++) {
            int bitSum = 0;
            int mask = (1 << i);
            for (int num : nums) {
                bitSum += (num & mask) != 0 ? 1 : 0;
            }
            // System.out.println("i " + i + " bitSum " + bitSum + " mask " + mask);
            if ((bitSum % 3) != 0) {
                ret |= mask;
            }
        }
        return ret;
    }
}
