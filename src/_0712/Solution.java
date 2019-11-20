package _0712;/*
 * @lc app=leetcode.cn id=712 lang=java
 *
 * [712] 两个字符串的最小ASCII删除和
 *
 * https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
 *
 * algorithms
 * Medium (59.61%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    2.6K
 * Total Submissions: 4.4K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 * 
 * 示例 1:
 * 
 * 
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 
 * 
 * 注意:
 * 
 * 
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minimumDeleteSum(final String s1, final String s2) {
        final char[] c1 = s1.toCharArray();
        final char[] c2 = s2.toCharArray();
        final int th1=c1.length;
        final int th2=c2.length;
        final int[][] dp=new int[th1+1][th2+1];
        if(0==th1&&0==th2) return 0;
        if(1==th1&&0==th2) return c1[0];
        if(0==th1&&1==th2) return c2[0];
        //dp[0][1]=c2[0];
        //dp[1][0]=c1[0];
        dp[0][0]=0;
        for(int i=1;i<=th1;i++) dp[i][0]=c1[i-1]+dp[i-1][0];
        for(int j=1;j<=th2;j++) dp[0][j]=c2[j-1]+dp[0][j-1];
        
        for(int i=1;i<=th1;i++){
            for(int j=1;j<=th2;j++){
                if(c1[i-1]==c2[j-1]) 
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=min(dp[i-1][j]+c1[i-1],dp[i][j-1]+c2[j-1],dp[i-1][j-1]+c1[i-1]+c2[j-1]);
            }
        }
        return dp[th1][th2];
    }
    public int min(final int a, final int b, final int c){
        final int temp = a<=b?a:b;
        return temp<=c?temp:c;
    }
}
// @lc code=end

