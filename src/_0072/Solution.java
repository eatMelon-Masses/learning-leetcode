package _0072;/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 *
 * https://leetcode-cn.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (55.05%)
 * Likes:    398
 * Dislikes: 0
 * Total Accepted:    19.5K
 * Total Submissions: 35.4K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 
 * 
 * 示例 1:
 * 
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释: 
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 
 * 
 * 示例 2:
 * 
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释: 
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * 
 * 
 */

// @lc code=start
class Solution {
    /** public int minDistance(String word1, String word2) {
        char c1 = word1.toCharArray();
        char c2 = word2.toCharArray();
        int th1 = c1.length;
        int th2 = c2.length;
        if(th1!=0 && th2==0) return th1;
        if(th1==0 && th2!=0) return th2;
        int[][] dp = new int[th1+1][th2+1];
        for(int i=0;i<=th1;i++) dp[th1][0]=i;
        for(int j=0;j<=th2;j++) dp[0][th2]=j;
        for(int i=1;i<=th1-1;i;++){//c1中第几个字符
            for(int j=1;j<=th2-1;j++){
                int a=c1[i-1];
                int b=c1[i];
                int c= c2[j-1];
                if(a==c){
                    dp[i][j]==dp[i-1][j-1];
                }else if(b==c){
                    dp[i][j]==dp[i-1][j-1]+1;
                    i++;
                    dp[i][j]=dp[i-1][j];
                }else if((th1-1-i)>(th2-1-j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    i++;
                    dp[i][j]=dp[i-1][j];
                }
            }
            
        }
        //if(th1&1==1) dp[]
        if(th1<th2)
            return dp[th1-1][th2-1]+;
    }*/
    public int minDistance(final String word1, final String word2) {
        final char[] c1 = word1.toCharArray();
        final char[] c2 = word2.toCharArray();
        final int th1 = c1.length;
        final int th2 = c2.length;
        if(th1!=0 && th2==0) return th1;
        if(th1==0 && th2!=0) return th2;
        final int[][] dp = new int[th1+1][th2+1];
        for(int i=0;i<=th1;i++) dp[i][0]=i;
        for(int j=0;j<=th2;j++) dp[0][j]=j;

        for(int i=1;i<= th1;i++){//c1中第几个字符
            for(int j=1;j<=th2;j++){
                
                final char a=c1[i-1];
                final char c= c2[j-1];
                if(a==c){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1);
                }
            }
            
        }
        //if(th1&1==1) dp[] 
        return dp[th1][th2];
    }
    public int min(final int a, final int b, final int c){
          final int temp=a<b?a:b;
        return temp<c?temp:c;        
    }

}
// @lc code=end

