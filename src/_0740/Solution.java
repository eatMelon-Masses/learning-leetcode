package _0740;/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除与获得点数
 *
 * https://leetcode-cn.com/problems/delete-and-earn/description/
 *
 * algorithms
 * Medium (49.62%)
 * Likes:    74
 * Dislikes: 0
 * Total Accepted:    2.4K
 * Total Submissions: 4.7K
 * Testcase Example:  '[3,4,2]'
 *
 * 给定一个整数数组 nums ，你可以对它进行一些操作。
 * 
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i]
 * + 1 的元素。
 * 
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [3, 4, 2]
 * 输出: 6
 * 解释: 
 * 删除 4 来获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [2, 2, 3, 3, 3, 4]
 * 输出: 9
 * 解释: 
 * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * 
 * 
 * 注意:
 * 
 * 
 * nums的长度最大为20000。
 * 每个整数nums[i]的大小都在[1, 10000]范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int deleteAndEarn(final int[] nums) {
        if(nums.length==1) return nums[0];
        final int[] v = new int[10001];
        for(final int i:nums){
            v[i]+=i;
        }
        final int[] skip = new int[10001];
        final int[] take = new int[10001];
        skip[1]=0;
        take[1]=v[1];
        for(int i=2;i<=v.length-1;i++){
            take[i]=skip[i-1]+v[i];
            skip[i]=Math.max(take[i-1],skip[i-1]);
        }
        return Math.max(take[10000],skip[10000]);
    }
}
// @lc code=end

