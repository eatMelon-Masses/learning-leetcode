package _0561;/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 *
 * https://leetcode-cn.com/problems/array-partition-i/description/
 *
 * algorithms
 * Easy (68.20%)
 * Likes:    122
 * Dislikes: 0
 * Total Accepted:    23.2K
 * Total Submissions: 34K
 * Testcase Example:  '[1,4,3,2]'
 *
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到
 * n 的 min(ai, bi) 总和最大。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,4,3,2]
 * 
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 
 * 
 * 提示:
 * 
 * 
 * n 是正整数,范围在 [1, 10000].
 * 数组中的元素范围在 [-10000, 10000].
 * 
 * 
 */

// @lc code=start
class Solution {
    public int arrayPairSum(final int[] nums) {
        if(nums.length==0) return 0;
        final int[] sortedArray = sort(nums);
        final int end = sortedArray.length-1;
        int minSum = 0;
        boolean sign = false;
        for(int i =0;i<=end;i++){
            int subSum = sortedArray[i];
            if(subSum==0) continue;
            if(sign){
                subSum--;
                sign=false;
            }
            if(subSum==0) continue;
            
            sign = ((subSum&1)==1);
            if(sign) subSum++;
            minSum= minSum+(subSum/2)*(i-10000);
        }
        return minSum;
    }
    public int[] sort(final int[] nums){
        final int[] sortArray =new int[20001];
        for(int i = 0; i<=nums.length-1;i++){
            final int index = nums[i]+10000;
            sortArray[index]=sortArray[index]+1;
        }
        return sortArray;       
    }
}
// @lc code=end

