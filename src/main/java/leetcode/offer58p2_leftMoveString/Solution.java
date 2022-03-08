package leetcode.offer58p2_leftMoveString;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int deltaI = i + n;
            int index = deltaI % s.length();
            arr[i] = s.charAt(index);
        }
        return new String(arr);
    }
}
