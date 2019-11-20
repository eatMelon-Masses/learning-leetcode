package _0693;/*
 * @lc app=leetcode.cn id=693 lang=java
 *
 * [693] 交替位二进制数
 *
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/description/
 *
 * algorithms
 * Easy (60.02%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    8.9K
 * Total Submissions: 14.9K
 * Testcase Example:  '5'
 *
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * 
 * 
 * 示例 4:
 * 
 * 
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(final int n) {
        int bitResult = n;
        int p = bitResult&1;
        bitResult>>=1;
        while(bitResult>0){  
            final int q =bitResult&1;
            if((p^q)==0){
                return false;
            }
            p=q;
            bitResult>>=1;
        }
               return true;
    }
}
// @lc code=end

