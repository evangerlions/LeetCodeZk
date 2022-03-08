package leetcode.offer58_reverseWordOrder;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Solution_Simple {
    List<String> list = new LinkedList<>();

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if (!sb.isEmpty()) {
                    addToList(sb);
                    sb = new StringBuilder();
                }
                continue;
            }
            sb.append(s.charAt(i));
        }
        addToList(sb);

        sb = new StringBuilder();
        boolean first = true;
        for(String item : list) {
            if (first) {
                first = false;
                sb.append(item);
            } else {
                sb.append(" ");
                sb.append(item);
            }

        }
        return sb.toString();
    }

    private void addToList(StringBuilder sb) {
        if (sb.isEmpty()) return;
        String s = sb.toString();
        char[] arr = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[s.length() - 1 - i] = s.charAt(i);
        }
        list.add(new String(arr));
    }
}
