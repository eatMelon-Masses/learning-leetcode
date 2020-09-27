package _0746;

public class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[1] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            dp[i+1]  = Math.min(dp[i-1] + cost[i],dp[i] +cost[i]);

        }
        return Math.min(dp[cost.length - 1], dp[cost.length]);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.minCostClimbingStairs(new int[]{10, 15, 20});
        System.out.println(result);
    }
}
