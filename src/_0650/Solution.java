package _0650;

/**
 * rul: https://leetcode-cn.com/problems/2-keys-keyboard/
 * dp
 * 题解思路：
 * 	设:f(x) 为x个数字所需操作的次数
 *
 *			0 (x <=1)
 * 	f(x)=	x (x为奇数)
 * 			f(x/2)+2 (x为偶数)
 */
public class Solution {
	public int minSteps(int n) {
		int[] dp = new int[n+1];
		for (int i = 2; i < dp.length; i++) {
			if ((i & 1) == 1) {
				dp[i] = i;
			} else {
				dp[i] = dp[i / 2] + 2;
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minSteps(500));
	}
}
