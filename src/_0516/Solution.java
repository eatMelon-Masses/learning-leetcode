package _0516;

/**
 *
 * dp
 * url https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 					1. 2 + f(i+1,j-1)  s[i] =s[j]
 * 思路：F(i,j)=
 * 					2. max{f(i+1,j),f(i,j-1)} s[i] !=s[j]
 */
public class Solution {
	public int longestPalindromeSubseq(String s) {
		if (s.isEmpty()) return 0;
		int len = s.length();
		int[][] dp = new int[len][len];
		for (int i = len-1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i+1; j < len ; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] +2;
				}else{
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = "qq";
		System.out.println(solution.longestPalindromeSubseq(s));
	}
}
