package _0442;/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 *
 * https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/description/
 *
 * algorithms
 * Medium (62.06%)
 * Likes:    128
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 14.2K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 
 * 找到所有出现两次的元素。
 * 
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * 
 * 示例：
 * 
 * 
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 
 * 输出:
 * [2,3]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(final int[] nums) {
        if(nums.length==1) return new ArrayList<Integer>();
        if(nums.length==2 && nums[0]!=nums[1]) return new ArrayList<Integer>();
        final List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<=nums.length-1;i++){
            if(nums[i]==-1||(i+1)==nums[i]) continue;
            while(nums[i]!=-1&&nums[i]!=i+1&&changeNum(nums,i,result));
        }
        return result;
    }
    public boolean changeNum(final int[] nums, final int index, final List<Integer> result){
        final int e = nums[index];
        final int nextChangeNum = nums[e-1];
        if(nextChangeNum == e){
            result.add(e);
            nums[index]=-1;
            return false;
        }
        nums[index]=nextChangeNum;
        nums[e-1]=e;
        return true;
    }
}
// @lc code=end

