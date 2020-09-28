package _0714;

import static java.lang.Integer.max;

/**
 * dp1[i] 表示第i天手上有股票，dp2[i]表示第i天手上没有股票
 * dp1[i] = max(dp1[i-1],dp2[i-1]-prices[i]);
 * dp2[i] = max(dp2[i-1],dp1[i-1] + prices[i] - fee);
  */
public class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        if (prices.length<2) return 0;
        dp1[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
        dp1[i] = Math.max(dp1[i-1],dp2[i-1]-prices[i]);
        dp2[i] = max(dp2[i-1],dp1[i-1] + prices[i] - fee);
        }
        return dp2[prices.length - 1];

    }
    public static void main(String[] args) {

    }
}
