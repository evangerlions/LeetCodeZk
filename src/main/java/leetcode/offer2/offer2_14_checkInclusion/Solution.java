package leetcode.offer2.offer2_14_checkInclusion;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] charMap = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            charMap[s1.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;

        while(j < s2.length()) {
            charMap[s2.charAt(j) - 'a']--;
            if (j - i + 1 < s1.length()) {
                j++;
            } else {
                if (allZero(charMap)) return true;
                j++;
                charMap[s2.charAt(i) - 'a']++;
                i++;
            }
        }

        return false;
    }

    private boolean allZero(int[] charMap) {
        for (int i : charMap) {
            if (i != 0) return false;
        }
        return true;
    }
}
