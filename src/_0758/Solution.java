package _0758;


import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author yiezi
 * url:https://leetcode-cn.com/problems/bold-words-in-string/
 * tag: string
 */
public class Solution {
    StringBuilder sb = new StringBuilder();
    public String boldWords(String[] words, String S) {
        ArrayList<HashSet<String>> letters = getLetters(words);
        int p = 0;
        int q = 0;
        int len = S.length();
        while (p < len) {
            HashSet<String> set = letters.get(S.charAt(p) - 97);
            int end = Math.min(len, q + 10);
            boolean sign = false;
            for (int i = end; i > q ; i--) {
                String temp = S.substring(p, i);
                if (set.contains(temp)) {
                    q = i;
                    sign = true;
                    break;
                }
            }
            if (sign) {
                output(S, p, q);
            } else if (q < len) {
                sb.append(S.charAt(q));
                p = q + 1;
                q = p;
            } else {
                p = q + 1;
                q = p;
            }
        }
        return sb.toString();
    }

    public void output(String s, int p, int q) {
        sb.append("<d>");
        sb.append(s, p, q);
        sb.append("</d>");
    }

    public ArrayList<HashSet<String>> getLetters(String[] words) {
        ArrayList<HashSet<String>> letters = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            letters.add(new HashSet<String>());
            char e = (char) (i + 97);
            for (String word :
                    words) {
                if (word.charAt(0) == e) {
                    HashSet<String> letter = letters.get(i);
                    letter.add(word);
                }
            }
        }
        return letters;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] arr1 = {"ab", "bc", "cd", "d"};
        String arr2 = "abbc";
        System.out.println(solution.boldWords(arr1, arr2));
    }
}
