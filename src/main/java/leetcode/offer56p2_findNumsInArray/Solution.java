package leetcode.offer56p2_findNumsInArray;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class Solution {
    int[] bitArray = new int[31];
    public int singleNumber(int[] nums) {
        for (int n : nums) {
            calculateBit(n);
        }

        int result = 0;
        int mask = 1;
        for (int i = 0; i < 31; i++) {
            if (bitArray[i] % 3 != 0) {
                result += mask;
            }
            mask = mask << 1;
        }
        return result;
    }

    public void calculateBit(int n) {
        for (int i = 0; i < 31; i++) {
            if ((1 & n) == 1) {
                bitArray[i]++;
            }
            n = n >> 1;
        }
    }
}
