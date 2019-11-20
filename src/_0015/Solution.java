package _0015;/*
 * @lc app=leetcode.cn id=15 lang=java
 * tag: array
 * [15] 三数之和
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(final int[] nums) {
        final List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<3) return res;
        Arrays.sort(nums);
       for(int i = 0;i<nums.length;i++){
           final int one = nums[i];
           if(one>0) return res;
           if(i>0 && one == nums[i-1]) continue;
           int left = i+1;
           int right = nums.length-1;
           while(left < right){
               final int sum = nums[i] +nums[left] + nums[right];
               if(sum == 0){
                 res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                 while(left<right && nums[left] ==nums[left+1]) left++;
                 while(left<right && nums[right] == nums[right-1]) right--;
                 left++;
                 right--;
               }else if(sum<0) left++;
               else if(sum>0) right--;
           }
            
       }
       return res; 
    }
}
// @lc code=end

