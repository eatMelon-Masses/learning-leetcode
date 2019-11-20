package _0136;/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 *
 * https://leetcode-cn.com/problems/single-number/description/
 *
 * algorithms
 * Easy (64.17%)
 * Likes:    919
 * Dislikes: 0
 * Total Accepted:    120.2K
 * Total Submissions: 187.3K
 * Testcase Example:  '[2,2,1]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,1]
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * 
 */

// @lc code=start
class Solution {
    /**public int singleNumber(int[] nums) {
        if(nums.length<2) return nums[0];
        int p=0,q=1;
        Arrays.sort(nums);
        if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
        for(;q<=nums.length-1;q=q+2,p=p+2){
            if(nums[p]!=nums[q]) return nums[p];
        }
        return 0;
    }*/
        public int singleNumber(final int[] nums) {
         int num = 0;
         for (int i = 0; i < nums.length; i++) {
             num = num ^ nums[i];
         }
         return num;
    }
}
// @lc code=end

