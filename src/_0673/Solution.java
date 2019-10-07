package _0673;

import java.util.Arrays;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if(len<=1) return len;
        int[] dp = new int[len];
        int[] counts = new int[len];
        Arrays.fill(counts, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] >= dp[i]) {
                        dp[i] =dp[j]+1;
                        counts[i] =counts[j];
                    } else if (dp[i] == dp[j] + 1) {
                        counts[i]+=counts[j];
                    }
                }
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (max == dp[i]) {
                ans += counts[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(counts));
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNumberOfLIS(new int[]{1 }));
    }
}
