package leetcode.offer2.offer2_5_maxProduct;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * https://leetcode-cn.com/problems/aseY1I/
 */
public class Solution {
    public int maxProduct(String[] words) {
        int[] flag = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                flag[i] = flag[i] | (1 << (c - 'a'));
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flag[i] & flag[j]) == 0) {
                    // System.out.println("" + words[i] + " " + words[j]);
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
