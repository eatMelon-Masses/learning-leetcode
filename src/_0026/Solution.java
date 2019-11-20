package _0026;/*
 * @lc app=leetcode.cn id=26 lang=java
 * tag: array
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(final int[] nums) {
    int p=0;
        int q=1;
        final int w=1;
        int length=nums.length;
        if(nums==null) return 0;
    if(length<2) return nums.length;
     while(q<=nums.length-1){
         boolean sign = false;
         while(q<=nums.length-1&&nums[p]==nums[q]){
             q++;
             sign=true;
             length--;
         }
         if(q<=nums.length-1){
             nums[p+1]=nums[q];
             p++;
             q++;
         }

     }
        return length;
    }
}
// @lc code=end

