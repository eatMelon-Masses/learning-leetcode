package _0215;/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (59.22%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    57.9K
 * Total Submissions: 97.6K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

import java.util.PriorityQueue;

// @lc code=start
class Solution {
    public int findKthLargest(final int[] nums, final int k) {
        if(nums.length ==1) return nums[0];
		final PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int i = 0;
		for (final int e : nums) {
			queue.add(e);
			i++;
			if (i > k) {
				queue.poll();
			}
		}
		return queue.peek();        
    }
}
// @lc code=end

