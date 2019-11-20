package _0268;/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (53.11%)
 * Likes:    183
 * Dislikes: 0
 * Total Accepted:    38.1K
 * Total Submissions: 71.8K
 * Testcase Example:  '[3,0,1]'
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 示例 1:
 * 
 * 输入: [3,0,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int missingNumber(final int[] nums) {
        final int[] res = new int[nums.length+1];
        Arrays.fill(res,-1);
        for(int i =0;i<nums.length;i++){
            final int e = nums[i];
            res[e] = e;
        }
        for(int j = 0;j<res.length;j++){
            if(res[j] == -1) return j;
        }
        return 0;
    }
}
// @lc code=end

