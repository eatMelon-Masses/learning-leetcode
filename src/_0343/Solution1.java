package _0343;

public class Solution1 {
    public int cuttingRope(int n) {
        if (n==2) return 1;
        if (n==3) return 2;
        int max =1;
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 3;
        for (int i = 4; i <=n ; i++) {
            for (int j = 1; j <= n / 2; j++) {
                max=Math.max(max, dp[i - j] * dp[j]);
            }

        }
        return max;
     }
}
