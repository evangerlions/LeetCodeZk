package leetcode.offer2.offer2_17_minWindow;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> cur = new HashMap<>();
        int j = 0;
        int i = 0;
        int minI = 0;
        int minJ = 0;
        boolean hasResult = false;
        while(j < s.length()) {
            char c = s.charAt(j);
            if (tMap.get(c) != null) {
                cur.put(c, cur.getOrDefault(c, 0) + 1);
            }

            while (allGreaterZero(cur, tMap)) {
                if (!hasResult || j - i + 1 < minJ - minI + 1) {
                    hasResult = true;
                    minI = i;
                    minJ = j;
                }

                Integer count =  cur.get(s.charAt(i));
                if (count != null) {
                    cur.put(s.charAt(i), count - 1);
                }

                i++;
            }

            j++;
        }

        return !hasResult ? "" : s.substring(minI, minJ + 1);
    }

    private boolean allGreaterZero(HashMap<Character, Integer> cur, HashMap<Character, Integer> tMap) {
        for (HashMap.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (cur.getOrDefault(entry.getKey(), 0) < entry.getValue()) return false;
        }

        return true;
    }
}
