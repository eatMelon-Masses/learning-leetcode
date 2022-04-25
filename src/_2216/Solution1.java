package _2216;

class Solution1 {
    public int minDeletion(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        dp[0]=0;
        for(int idx = 1;idx<l;idx++){
            int dCount = 0;
                dCount = dp[idx-1];
            if((idx-1-dCount)%2==0){
                if(nums[idx] == nums[idx-1]){
                    dp[idx] = dp[idx-1] +1;
                    continue;
                }
            }
            if (idx > 1) {
                dp[idx] = Math.min(dp[idx-2]+1,dp[idx-1]);

            }else{
                dp[idx] = Math.min(1,dp[idx-1]);
            }
        }
        return (l-dp[l-1])%2==0?dp[l-1]:dp[l-1]+1;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        //solution.minDeletion(new int[]{8,8,1,3,2,0,1,2,5});
        solution.minDeletion(new int[]{7,3});
    }
}