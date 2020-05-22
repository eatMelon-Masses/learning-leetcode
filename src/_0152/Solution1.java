package _0152;

public class Solution1 {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        if(len==1) return nums[0];
        int[][] dp = new int[len][len];
        for(int k = 0;k<len;k++){
            if (nums[k]==0) nums[k] = 1;
            dp[0][k]*=nums[k];
            if(dp[0][k]>max);
            max=dp[0][k];
        }
        for(int i = 0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(dp[i][i]==0){
                    dp[i+1][j]=0;
                }else{
                    dp[i+1][j]=dp[i][j]/dp[i][i];
                }
                if(dp[i+1][j]>max) max = dp[i+1][j];
            }
        }
        return max;
    }
    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        int[] arr = {2, 0, -1};
        System.out.println(solution.maxProduct(arr));
    }
}
