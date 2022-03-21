package leetcode.offer.offer48_longestSubStringWithoutRepeatCharacters;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
class Solution {
    // 0 1 2 3 4
    // a b b d a
    // 1 2 3 3 3
    private static final int CHAR_LEN = 26;

    public int lengthOfLongestSubstring(String s) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int[] b= ans.stream().mapToInt(it -> (it)).toArray();
        int max = 0;
        int curMax = 0;
        HashMap<Character, Integer> dp = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer preI = dp.get(c);


            if (preI == null || i - preI > curMax) {
                curMax += 1;
            } else {
                curMax = i - preI;
            }
            dp.put(c, i);
            max = Math.max(max, curMax);
        }

        return max;
    }
}