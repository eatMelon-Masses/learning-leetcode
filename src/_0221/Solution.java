package _0221;



/**
 * dp
 * url:https://leetcode-cn.com/problems/maximal-square/
 * 思路：dp[i][j] = 1+min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])
 */
public class Solution {
	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row+1][col+1];
		int max = 0;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}
//	public int[][] change(char[][] m){
//		int[][] res = new int[m.length][m[0].length];
//		for (int i = 0; i <m.length ; i++) {
//			for (int j = 0; j < m[i].length; j++) {
//				res[i][j] = m[i][j]-48;
//			}
//		}
//		return res;
//	}
	public static void main(String[] args) {
		char[][] arr = new char[][]{{'0', '1'}, {'1', '1'}};
		Solution solution = new Solution();
		System.out.println(solution.maximalSquare(arr));
	}
}
