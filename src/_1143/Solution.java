package _1143;

/**
 * @author yiezi
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。

 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]从 0-i 和 从0-j 最长公共子序列为多少
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int j = 0; j < text2.length(); j++) {
            for (int i = 0; i < text1.length(); i++) {
                if (chars1[i] == chars2[j]) {
                    dp[i+1][j+1]= dp[i][j]+1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.longestCommonSubsequence("abcde", "ace");
        System.out.println(result);
    }
}
