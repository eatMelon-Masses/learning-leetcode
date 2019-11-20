package _0665;/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 *
 * https://leetcode-cn.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Easy (20.80%)
 * Likes:    195
 * Dislikes: 0
 * Total Accepted:    10.1K
 * Total Submissions: 48.4K
 * Testcase Example:  '[4,2,3]'
 *
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 
 * 
 * 说明:  n 的范围为 [1, 10,000]。
 * 
 */

// @lc code=start
class Solution {
    public boolean checkPossibility(final int[] nums) {
        if(nums.length <=2) return true;
        boolean sign = true;
        if(nums[0]>nums[1]){
            nums[0] = nums[1];
            sign = false;
        }
        int i =1;
        for(;i<nums.length-2;i++){
            if(nums[i]>nums[i+1]){
                if(sign){
                    final int temp = nums[i];
                    nums[i] = nums[i-1];
                    if(desc(nums)){
                        nums[i] = temp;
                        nums[i+1] = temp;
                    }
                    if(desc(nums)){
                         return false;
                    }else{
                        return true;
                    }
                }else{
                    return false;
                }
            }
        }
        if(!sign && nums[i] > nums[i+1]) return false;
        //System.out.println(i+","+Arrays.toString(nums));
        return true;
    }
    public boolean desc(final int[] nums){
        for(int i =1;i<nums.length;i++){
            if(nums[i]<nums[i-1]) return true;
        }
        return false;
    }
}
// @lc code=end

