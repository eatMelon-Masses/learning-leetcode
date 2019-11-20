package __0001;/*
 * @lc app=leetcode.cn id=1 lang=java
 * tag: array
 * [1] 两数之和
 */

import java.util.HashMap;
import java.util.Map;

// @lc code=start
class Solution {
    public int[] twoSum(final int[] nums, final int target) {
        final Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
        final int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            final int sedNum=target-nums[i];

            if(temp.containsKey(sedNum)){
                ans[0]=i;
                ans[1]=temp.get(sedNum);
                return ans;
            }            
            temp.put(nums[i],i);
        }
            return ans;
    }
}
// @lc code=end

