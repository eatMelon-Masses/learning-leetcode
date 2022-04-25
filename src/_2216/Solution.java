package _2216;

class Solution {
    public int minDeletion(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        dp[0]=0;
        for(int i = 1;i<l;i++){
            int min = l;
            for(int j =i-1;j>=0;j--){
                int dis = i - j-1;
                if((j-dp[j])%2==1){
                    min = Math.min(min,dp[j]+ dis);
                }else{
                    if(nums[j] != nums[i]){
                        min =  Math.min(min,dp[j]+ dis);
                    }else{
                        min = Math.min(min,dp[j]+1 + dis);
                    }
                    
                }

            }
            if(min!=l) dp[i] = min;
            System.out.println(dp[i]);
        }
        return (l-1)%2==0?dp[l-1]:dp[l-1]+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minDeletion(new int[]{1,1,2,3,5});
    }
}