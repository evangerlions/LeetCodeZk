package leetcode.offer.offer50_firstCharShowOnce;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/submissions/
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
class Solution {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    // 借助数组实现
    public char firstUniqChar_array(String s) {
        int[] arr = new int[26];
        int[] order = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}