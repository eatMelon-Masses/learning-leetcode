package _0154;/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 *
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Hard (45.60%)
 * Likes:    52
 * Dislikes: 0
 * Total Accepted:    9.1K
 * Total Submissions: 20K
 * Testcase Example:  '[1,3,5]'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7]  可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 请找出其中最小的元素。
 * 
 * 注意数组中可能存在重复的元素。
 * 
 * 示例 1：
 * 
 * 输入: [1,3,5]
 * 输出: 1
 * 
 * 示例 2：
 * 
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 
 * 说明：
 * 
 * 
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMin(final int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while( left + 1 < right ){
            mid = (left + right) >> 1;
            //System.out.println(mid);
            if(nums[mid] == nums[right]){
             right = right -1;   
            }else if(nums[mid] > nums[right]){
                left = mid;
            }else{
                right = mid;
            }
        }
        //if(left != nums.length -1) return nums[left + 1];
        //System.out.println("left"+left);
        //System.out.println("right"+right);
        final int result = nums[left] > nums[right]?nums[right]:nums[left];
        return result;
    }
}

// @lc code=end

