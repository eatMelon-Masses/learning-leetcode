package _0213;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length<2) return Arrays.stream(nums).max().orElse(0);
        int[] arr1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(dp(arr1), dp(arr2));
    }
    public int dp(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int left = nums[i];
            if (i - 2 >= 0) {
                left += dp[i - 2];
            }
            dp[i] = Math.max(left, dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }
}
