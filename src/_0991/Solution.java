package _0991;/*
 * @lc app=leetcode.cn id=991 lang=java
 *
 * [991] 坏了的计算器
 *
 * https://leetcode-cn.com/problems/broken-calculator/description/
 *
 * algorithms
 * Medium (50.53%)
 * Likes:    32
 * Dislikes: 0
 * Total Accepted:    2.5K
 * Total Submissions: 5K
 * Testcase Example:  '2\n3'
 *
 * 在显示着数字的坏计算器上，我们可以执行以下两种操作：
 * 
 * 
 * 双倍（Double）：将显示屏上的数字乘 2；
 * 递减（Decrement）：将显示屏上的数字减 1 。
 * 
 * 
 * 最初，计算器显示数字 X。
 * 
 * 返回显示数字 Y 所需的最小操作数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：X = 2, Y = 3
 * 输出：2
 * 解释：先进行双倍运算，然后再进行递减运算 {2 -> 4 -> 3}.
 * 
 * 
 * 示例 2：
 * 
 * 输入：X = 5, Y = 8
 * 输出：2
 * 解释：先递减，再双倍 {5 -> 4 -> 8}.
 * 
 * 
 * 示例 3：
 * 
 * 输入：X = 3, Y = 10
 * 输出：3
 * 解释：先双倍，然后递减，再双倍 {3 -> 6 -> 5 -> 10}.
 * 
 * 
 * 示例 4：
 * 
 * 输入：X = 1024, Y = 1
 * 输出：1023
 * 解释：执行递减运算 1023 次
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= X <= 10^9
 * 1 <= Y <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int brokenCalc(final int X, final int Y) {

        return function(X, Y, 0);
    }

    private int function(final int x, final int y, final int k) {
        int count=0;

        if (x >= y) {
            return count+x - y;
        }
        final boolean condation = (y&1)==1;
        count++;
        //奇数
        if (condation) {
            count+=function(x, y + 1, count);
        } else {
            count+=function(x, y / 2, count);
        }
        return count;
    }
}
// @lc code=end
