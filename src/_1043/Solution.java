package _1043;

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        if (arr.length == 1) return arr[0];
        int len = arr.length;
        int[] dp = new int[arr.length+1];
        //dp[1] = arr[0];
        //dp[2] = Math.max(arr[0], arr[1]) * 2;
        for (int i = 0; i < len; i++) {
            for (int j = Math.max((i - k), 1); j <  len; j++) {

                dp[i+1] = Math.max(dp[i+1], dp[j] + arr[j] * (len - j) );

            }
        }
        return dp[len - 1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumAfterPartitioning(new int[]{1, 15, 7}, 3));
    }
}
