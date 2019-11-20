package _0005;/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.62%)
 * Likes:    1461
 * Dislikes: 0
 * Total Accepted:    140.5K
 * Total Submissions: 508.5K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(final String s) {
        final int max=0;
        final int index=0;
        if(s==null) return "";
        final char[] a =s.toCharArray();
        if(a.length==0) return "";
        if(a.length==1) return s;
        final Result result = new Result();
        for(int i=0;i<=a.length-1;i++){
            
            helper(a,i,i,result);
            helper(a,i,i+1,result);           
        }

        return new String(a,result.index,result.max);
    }
    public void helper(final char[] a, int left, int right, final Result result){
        while(left>=0&&right<=a.length-1 && a[left]==a[right]){
            if(right-left+1>result.max){
                result.max=right-left+1;
                result.index=left;
            }
            //max=Math.max(max,);
            left--;
            right++;
        }

    }
    class Result{
        int max=0;
        int index=0;
    }
}
// @lc code=end

