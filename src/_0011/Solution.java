package _0011;/*
 * @lc app=leetcode.cn id=11 lang=java
 * tag: array
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(final int[] height) {
        int left = 0;
        int right = height.length -1;
        int max = 0;
        while(left < right){
            final int width ;
            final int length = right -left;
            if(height[left] >= height[right]){
                width = height[right--];
            }else{
                width = height[left++];
            }
            max = Math.max(length * width,max);
            
        }
        return max;
    }
}
// @lc code=end

