package _0389;/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 *
 * https://leetcode-cn.com/problems/find-the-difference/description/
 *
 * algorithms
 * Easy (59.56%)
 * Likes:    94
 * Dislikes: 0
 * Total Accepted:    16.7K
 * Total Submissions: 28.1K
 * Testcase Example:  '"abcd"\n"abcde"'
 *
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * 
 * 输出：
 * e
 * 
 * 解释：
 * 'e' 是那个被添加的字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public char findTheDifference(final String s, final String t) {
         int temp = 0;
         for(int i = 0;i<s.length();i++){
             temp =temp ^ s.charAt(i) ^ t.charAt(i);
         }
        temp= temp ^ t.charAt(t.length()-1);
        return (char)temp ;
    }
}
// @lc code=end

