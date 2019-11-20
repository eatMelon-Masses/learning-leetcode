package _0414;/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (33.28%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    14.2K
 * Total Submissions: 42.7K
 * Testcase Example:  '[3,2,1]'
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 2, 1]
 * 
 * 输出: 1
 * 
 * 解释: 第三大的数是 1.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1, 2]
 * 
 * 输出: 2
 * 
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [2, 2, 3, 1]
 * 
 * 输出: 1
 * 
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 
 * 
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {
    public int thirdMax(final int[] nums) {
        if(nums.length == 0) return 0;
        final int one = Arrays.stream(nums).max().getAsInt();
        final int two = range(nums,one);
        final int three = range(nums,two);
        final Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(e-> set.add(e));
        int res = 0;
        //System.out.println(one+","+two+","+three);
        if(set.size()<3)return one;
        res = three;
        return res;
        
    }
    public int range(final int[] nums, final int better){
        int res =  Integer.MIN_VALUE;
        for(final int n:nums){
            if(n >=  better) continue;
            res = Math.max(res,n);
        }
           System.out.println(res);
        return res;
    }

}
// @lc code=end

