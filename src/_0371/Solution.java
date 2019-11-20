package _0371;/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (52.53%)
 * Likes:    161
 * Dislikes: 0
 * Total Accepted:    17.9K
 * Total Submissions: 34K
 * Testcase Example:  '1\n2'
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 
 * 示例 1:
 * 
 * 输入: a = 1, b = 2
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = -2, b = 3
 * 输出: 1
 * 
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        final int ans = 0;
        while((a&b)!=0){
            final int temp1=a;
            final int temp2=b;
            a=(temp1&temp2)<<1;
            b=temp1^temp2;            
        }
        return a^b;
    }
}
// @lc code=end

