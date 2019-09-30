package _0375;

/**
 * dp
 * rul:https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/cai-shu-zi-da-xiao-ii-by-leetcode/
 */
public class Solution {
	public int calculate(int low, int high) {
		if (low >= high)
			return 0;
		int minres = Integer.MAX_VALUE;
		for (int i = low; i <= high; i++) {
			int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
			minres = Math.min(res, minres);
		}

		return minres;
	}
	public int getMoneyAmount(int n) {
		return calculate(1, n);
	}
}
