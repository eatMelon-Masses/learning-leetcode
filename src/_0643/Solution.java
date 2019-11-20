package _0643;/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 *
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (36.19%)
 * Likes:    60
 * Dislikes: 0
 * Total Accepted:    8K
 * Total Submissions: 22.2K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 
 * 示例 1:
 * 
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * 
 * 注意:
 * 
 * 
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMaxAverage(final int[] nums, final int k) {
        double sum = 0;
        double max = -10000;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            if(i>k-1){
                sum-=nums[i-k];
            }
            if(i>=k-1){
                final double temp =sum/k;
                max = temp>max?temp:max;
            }
        }
        return max;
    }
}
// @lc code=end

