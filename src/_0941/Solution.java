package _0941;/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 *
 * https://leetcode-cn.com/problems/valid-mountain-array/description/
 *
 * algorithms
 * Easy (34.16%)
 * Likes:    29
 * Dislikes: 0
 * Total Accepted:    5.5K
 * Total Submissions: 16K
 * Testcase Example:  '[2,1]'
 *
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * 
 * 
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * 
 * A[0] < A[1] < ... A[i-1] < A[i] 
 * A[i] > A[i+1] > ... > A[B.length - 1]
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[2,1]
 * 输出：false
 * 
 * 
 * 示例 2：
 * 
 * 输入：[3,5,5]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 输入：[0,3,2,1]
 * 输出：true
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000 
 * 
 * 
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validMountainArray(final int[] A) {
        if(A.length<3) return false;
        boolean a=false;
        boolean b = false;
        int i =0;
        while(i+1<=A.length-1 &&A[i]<A[i+1]) {
            i++;
            a=true;
        }
        //int j=i+1;
        while(i+1<=A.length-1 && A[i]>A[i+1]) {
            i++;
            b=true;
        }
        if(a&&b&&i==(A.length-1)) 
            return true;
        else
            return false;
    }
}
// @lc code=end

