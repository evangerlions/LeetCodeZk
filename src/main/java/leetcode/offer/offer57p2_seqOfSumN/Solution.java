package leetcode.offer.offer57p2_seqOfSumN;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 2;

        List<int[]> ret = new LinkedList<>();
        int sum = i + j;
        while (i < j) {
            if (sum < target) {
                j++;
                sum += j;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] seq = new int[j - i + 1];
                for (int k = 0; k < seq.length; k++) {
                    seq[k] = i + k;
                }
                ret.add(seq);
                j++;
                sum += j;
            }
        }

        return ret.toArray(new int[ret.size()][]);
    }
}
