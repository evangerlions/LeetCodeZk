package leetcode.offer.offer45_minNum;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class Solution {
    public String minNumber(int[] nums) {
        if (nums.length == 0) return "";

        LinkedList<String> numStrs = new LinkedList<>();

        for (int num : nums) {
            String str = Integer.toString(num);
            numStrs.add(str);
        }

        numStrs.sort((str1, str2) -> (str1 + str2).compareTo(str2 + str1));

        return String.join("", numStrs);
    }
}
