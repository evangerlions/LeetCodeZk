package leetcode.offer.offer48_longestSubStringWithoutRepeatCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution_SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) != null && map.get(c) >= start) {
                start = map.get(c) + 1;
            }

            // System.out.print(start + " " + i + " " + "len: " +  (i - start + 1) + " ");
            // for (Map.Entry cc : map.entrySet()) {
            //     System.out.print(cc);
            // }
            // System.out.println();
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
