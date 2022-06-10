package leetcode.offer2.offer2_32_isAnagram;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/dKk3P7/
 * 剑指 Offer II 032. 有效的变位词
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
