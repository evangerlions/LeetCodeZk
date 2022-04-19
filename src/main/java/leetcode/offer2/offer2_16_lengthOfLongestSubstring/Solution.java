package leetcode.offer2.offer2_16_lengthOfLongestSubstring;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/wtcaE1/
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 * 自创解法
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        int cur = 0;
        while(j < s.length()) {
            cur++;
            char c = s.charAt(j);

            Integer lastIndex = map.get(c);
            if (lastIndex != null && lastIndex >= j - cur + 1) {
                max = Math.max(max, cur - 1);
                cur =  j - lastIndex;
            }
            map.put(c, j);
            j++;
        }

        max = Math.max(max, cur);
        return max;
    }
}
