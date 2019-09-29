package _0300;

import java.util.Arrays;

/**
 *  dp
 * rul:https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Solution {
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if(len==0) return 0;
		int[] dp = new int[len];
		Arrays.fill(dp,1);
		for(int i = 0;i<len;i++){
			for(int j = 0;j<i;j++){
				if(nums[j] < nums[i]){
					dp[i] = Math.max(dp[j]+1,dp[i]);
				}
			}
		}
		return Arrays.stream(dp).max().getAsInt();
	}
}
