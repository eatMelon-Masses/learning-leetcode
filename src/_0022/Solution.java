package _0022;/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.45%)
 * Likes:    613
 * Dislikes: 0
 * Total Accepted:    53.7K
 * Total Submissions: 74.1K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> generateParenthesis(final int n) {
        final List<String> list = new ArrayList();
        if(n<1) return list;
        dg("",n,n,list);
        return list;
    }
    public void dg(final String s, final int left, final int right, final List list){
        if(left==0&&right==0){
            list.add(s);
            return;
        } 
        if(left==right){
            
            dg(s+"(",left-1,right,list);
        }
        else if(left<right){
            if(left!=0)
            dg(s+"(",left-1,right,list);
            dg(s+")",left,right-1,list);
            }
    }
}
// @lc code=end

