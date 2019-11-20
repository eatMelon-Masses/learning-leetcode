package _0646;/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 *
 * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (51.13%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    3.6K
 * Total Submissions: 7K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 
 * 示例 :
 * 
 * 
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * 
 * 
 * 注意：
 * 
 * 
 * 给出数对的个数在 [1, 1000] 范围内。
 * 
 * 
 */

import java.util.Arrays;
import java.util.Comparator;

// @lc code=start
class Solution {
    public int findLongestChain(final int[][] pairs) {
         if(pairs.length==1) 
         return 1;
         Arrays.sort(pairs,new Comparator<int[]>(){
         public int compare(final int[] o1, final int[] o2){
            return o1[0]-o2[0];
         }
     });
        final int[] dp = new int[pairs.length];
        dp[0]=1;
        for(int i=1;i<=pairs.length-1;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }else{
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }    
        }
             return dp[pairs.length-1];
    }
}
// @lc code=end

