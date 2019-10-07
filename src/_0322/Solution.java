package _0322;

import java.util.Arrays;

/**
 * url：https://leetcode-cn.com/problems/coin-change/
 * dp
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int preS = i-coins[j];
                if (preS >= 0) {
                    dp[i] = Math.min(dp[i], dp[preS]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1,2,5}, 11));
    }
}
