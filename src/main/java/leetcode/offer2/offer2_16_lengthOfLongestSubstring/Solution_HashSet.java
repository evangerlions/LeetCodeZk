package leetcode.offer2.offer2_16_lengthOfLongestSubstring;

import java.util.HashSet;

public class Solution_HashSet {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        int cur = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            while (set.contains(c)) {
                set.remove(s.charAt(i));
                i++;
                cur--;
            }

            set.add(c);
            cur++;
            j++;
            max = Math.max(max, cur);
        }

        return max;
    }
}
