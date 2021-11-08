package leetcode.offer38_stringAllArrange;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/submissions/
 */
class Solution {

    public String[] permutation(String s) {
        if (s == null || s.isEmpty()) return new String[0];

        char[] array = s.toCharArray();
        List<String> ans = new LinkedList<>();
        recusion(s, array, 0, ans);
        String[] ansArray = ans.toArray(String[]::new);
        return ansArray;
    }

    private void recusion(String s, char[] array, int start, List<String> ans) {
        if (start >= s.length() - 1) {
            ans.add(new String(array));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < s.length(); i++) {
            Character c = array[i];
            if (set.contains(c)) {
                // filter duplicate string
                continue;
            }
            set.add(c);

            swap(array, start, i);
            recusion(s, array, start + 1, ans);
            swap(array, start, i);

        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
