package leetcode.offer2.offer2_95_longestCommonSubsequence;

/**
 * https://leetcode-cn.com/problems/qJnOS7/
 * 剑指 Offer II 095. 最长公共子序列
 * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceOpt(text1, text2);
    }

    public int longestCommonSubsequenceOrigin(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
            if (text1.charAt(i) == text2.charAt(j)) {
                dp[i + 1][j + 1] = dp[i][j] + 1;
            } else {
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
            System.out.print(dp[i + 1][j + 1] + ", ");
        }
            System.out.println();
        }

        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequenceOpt(String text1, String text2) {
        int[] dp = new int[text2.length() + 1];

        int prev = 0;
        for (int i = 0; i < text1.length(); i++) {
            prev= 0;
            for (int j = 0; j < text2.length(); j++) {
            int cur = 0;
            if (text1.charAt(i) == text2.charAt(j)) {
                cur  = dp[j] + 1;
            } else {
                cur  = Math.max(dp[j + 1], prev);
            }
            dp[j] = prev;
            prev = cur;
            // System.out.print(dp[j] + " " + prev + ", ");

        }
            dp[text2.length()] = prev;
            // System.out.println();
        }

        return prev;
    }
}