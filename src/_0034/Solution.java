package _0034;/*
 * @lc app=leetcode.cn id=34 lang=java
 * tag: array
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    int[] nums;
    int target;
    public int[] searchRange(final int[] nums, final int target) {
        this.nums = nums;
        this.target = target;
        final int[] result = new int[]{-1,-1};
        if(nums.length == 0) return result;
        result[0] = left();
        if(result[0]!=-1){
            result[1] = right(result[0],nums.length-1);
        }
        return result;
    }
    public int left(){
        int left = 0;
        int right = nums.length -1;
        while( left < right){
            final int mid = (left + right) >> 1;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] > target){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
       // if(left==nums.length -1) return nums[left]== target?left:-1;;
        return nums[left]== target?left:-1;
    }
    public int right(final int start, final int end){
        int left = start;
        int right = end;
        while( left < right){
            final int mid = (left + right) >> 1;
            //System.out.println(mid);
            if(nums[mid+1] <= target){
                left = mid +1;
            }else{
                right = mid;
            }
        }
       // if(left==nums.length -1) return nums[left]== target?left:-1;;
        return nums[left]== target?left:-1;
    }    
}
// @lc code=end

