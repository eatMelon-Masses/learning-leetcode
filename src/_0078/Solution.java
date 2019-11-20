package _0078;/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.29%)
 * Likes:    378
 * Dislikes: 0
 * Total Accepted:    45K
 * Total Submissions: 59.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(final int[] nums) {
        final int length = nums.length;
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        final List<Integer> zeroList = new ArrayList<Integer>();
        result.add(zeroList);
        if(length==0)
            return result;
    
        final List<List<Integer>> dp = new ArrayList<List<Integer>>();
        //添加第一个数到dp和结果集中
        final List<Integer> firstNum = new ArrayList<Integer>();
        firstNum.add(nums[0]);
        dp.add(firstNum);
        result.add(firstNum);
        for(int i = 1;i<=length-1;i++){
            final List<List<Integer>> tempList = new ArrayList<List<Integer>>();
            final int e = nums[i];
            for(final List<Integer> buildNum:dp){
                final List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(buildNum);
                temp.add(e);
                tempList.add(temp);
            }
            //添加自身到dp和最终结果集
            final List<Integer> selfNum = new ArrayList<Integer>();
            selfNum.add(e);
            tempList.add(selfNum);
            dp.addAll(tempList);
            
            result.addAll(tempList);
        }
        return result;
    }
}
// @lc code=end

