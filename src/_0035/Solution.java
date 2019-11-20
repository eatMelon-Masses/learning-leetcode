package _0035;/*
 * @lc app=leetcode.cn id=35 lang=java
 * tag: array
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(final int[] nums, final int target) {
        if(nums.length ==1){
            if(nums[0] >= target){
                 return 0;
            }else{
                return 1;
            }
        }
        final int res = find(nums,target,true);
        if(nums[res] == target){
            return res;
        }else{
            return find(nums,target,false);
        }
    }
    public int find(final int[] nums, final int target, final boolean sign){
        int left = 0;
        int right = sign?nums.length-1:nums.length;
        int mid = 0;
        while(left < right){
             mid = (left + right)/2;
            if(sign && nums[mid] == target) return mid;
            if(nums[mid] <= target){
                left = mid+1;
            }else{
                right = sign?mid-1:mid;
            }
        }
        if(sign){
            //System.out.println(mid);
            return left;
        }else{
            return (left < nums.length-1 && nums[left] < target) ? left +1:left;
        }
    }
}
// @lc code=end

