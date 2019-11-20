package _0027;/*
 * @lc app=leetcode.cn id=27 lang=java
 * tag: array
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(final int[] nums, final int val) {
        final int length = nums.length;
        int k = 0;
        for(int i = 0;i<length;i++){
            if(nums[i]!=val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
// @lc code=end

