package _0137;/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 *
 * https://leetcode-cn.com/problems/single-number-ii/description/
 *
 * algorithms
 * Medium (64.66%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 24.2K
 * Testcase Example:  '[2,2,3,2]'
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,3,2]
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * 
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    Set set = new HashSet();
    public int singleNumber(final int[] nums) {
        final long noRepeatSum = 0;
        long sum = 0;
       for(int i=0;i<nums.length;i++){
          
           sum+=(needAddNum(nums[i])*3.0-nums[i]);
       }
        
        return (int)(sum/2.0);
    }
    public int needAddNum(final int num){
        if(set.contains(num)){
            return 0;
        }else{
            set.add(num);
            return num;
        }
    }
}
// @lc code=end

