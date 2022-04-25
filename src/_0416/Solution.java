package _0416;

/**
 * @author zhouye
 * @date 2022/4/8
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false;
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+= nums[i];
        }
        int mid = sum/2;
        if((sum&1)==1) return false;
        boolean[][] dp = new boolean[nums.length][mid+1];
        dp[0][0] = false;
        // System.out.println(2+","+2+"=="+dp[2][2]);
        for(int i = 0;i<nums.length;i++){

            dp[i][0]=true;
        }
        for(int j = 0;j<=mid;j++){
            if(nums[0] == j){
                dp[0][j]=true;
            }

        }
        for(int i =1;i<nums.length;i++){
            for(int j=1;j<=mid;j++ ){
                // if(j==nums[i]) dp[i][j] = true;
                if(j>=nums[i]){
                    dp[i][j] = dp[i][j]|| dp[i-1][j-nums[i]];
                }else{
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                System.out.println(i+","+j+"="+dp[i][j]);
            }
        }
        return dp[nums.length-1][mid];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canPartition(new int[]{2, 2, 1, 1});
    }
}
