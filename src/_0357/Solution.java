package _0357;

/**
 * url: https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
 * dp
 * 题解思路：
 *
 * 设f(n) 为n位各个位不同数字个数
 * f(n) = 首位非0情况+首位为0情况
 * 首位非0情况下：k(x)为排列组合函数
 * 首位为0情况：f(n-1) 为各个位不同数字个数
 * 状态转移方程：f(n) = k(x) +f(n-1)
 */
public class Solution {
	public int countNumbersWithUniqueDigits(int n) {
		if (n > 10) return 0;
		int[] arr = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int dp = 1;
		for (int j = 1; j <= n; j++) {
			int one = 1;
			for (int i = 0; i < j; i++) {
				one *= arr[i];
			}
			dp += one;
		}
		return dp;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countNumbersWithUniqueDigits(9));
	}
}
