package _0367;/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (42.46%)
 * Likes:    71
 * Dislikes: 0
 * Total Accepted:    17.7K
 * Total Submissions: 41.8K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(final int num) {
        int left = 0;
        int right = 46340;
        //System.out.println(46340 * 46340);
        while(left <= right){
            final int mid = (left + right) >> 1;
            final int midSqare =mid *mid;
            if(midSqare == num){
                return true;
            }else if(midSqare < num){
                left = left +1;
            }else{
                right = right -1;
            }
        }
        return false;
    }
}
// @lc code=end

