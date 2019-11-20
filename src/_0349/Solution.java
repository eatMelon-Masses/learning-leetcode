package _0349;/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (66.95%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    39.7K
 * Total Submissions: 59.4K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int[] intersection(final int[] nums1, final int[] nums2) {
        final Set<Integer> set = new HashSet<>();
        final Set<Integer> result = new HashSet<>();
        for(final int a:nums1){
            set.add(a);
        }
        for(final int b:nums2){
            if(set.contains(b)){
                result.add(b);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
// @lc code=end

