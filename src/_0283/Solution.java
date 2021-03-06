package _0283;/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (57.77%)
 * Likes:    438
 * Dislikes: 0
 * Total Accepted:    83.1K
 * Total Submissions: 143.8K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(final int[] nums) {
        if(nums.length<2) return ;
        int j=0;
        int count=0;
            while(j<=nums.length-1){
                while(j<=nums.length-1&&nums[j]!=0){//遇到0
                    nums[j-count]=nums[j]; 
                    j++;
                }
                while(j<=nums.length-1&&nums[j]==0) {
                    count++;
                    j++;
                    }
                
            }
            for(int i=nums.length-count;i<=nums.length-1;i++){
                nums[i]=0;
            }
        
    }
}
// @lc code=end

