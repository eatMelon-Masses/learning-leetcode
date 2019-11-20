package _0016;/*
 * @lc app=leetcode.cn id=16 lang=java
 * tag: array
 * [16] 最接近的三数之和
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int threeSumClosest(final int[] nums, final int target) {
        final int len = nums.length;
        int res = Integer.MAX_VALUE;
        int diff= Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i<len-2;i++){
            final int e = nums[i];
            int left = i+1;
            int right = len-1;
            int sum =0;

            while(left<right){
                sum=e+nums[left]+nums[right];
                //System.out.println(left+","+right+","+sum);
                if(sum == target){
                    return sum;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
                final int temp = Math.abs(sum-target);
                //System.out.println("diff"+diff+"res"+res);
                if(temp<diff){
                    res = sum;
                    diff =temp;
                }                
            }

            //System.out.println("res"+res);
        }
        return res;
    }
}
// @lc code=end

