package _0309;/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (50.34%)
 * Likes:    162
 * Dislikes: 0
 * Total Accepted:    9.6K
 * Total Submissions: 19.1K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 
 * 
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 
 * 
 * 示例:
 * 
 * 输入: [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 
 */

// @lc code=start
class Solution {
    /**public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int[] temp = new int[prices.length-1];
        for(int i=1;i<=prices.length-1;i++){
            temp[i-1]=prices[i]-prices[i-1];
        }
        int[] dp = new int[prices.length/2+1];
        int i=1;
        int sum=0;
        int count=0;
        for(int j=0;j<=temp.length-1;j++){
            int a =temp[j];
            if(a>=0){
                count++;
                sum+=a;
            }else if(sum>0){
                if(sum>dp[i-1]){
                 dp[i]=sum+dp[i-1];
                if((j-count)>0) dp[i]=dp[i-1]-temp[j-count];
                }else{
                 dp[i]=dp[i-1];   
                }
                count=0;
                sum=0;
            }    
        }
            return dp[i]+sum;
    }*/
public int maxProfit(final int[] prices) {
      if(prices.length<=1) return 0;
    int s0=0;
    int s1=-prices[0];
    int s2=Integer.MIN_VALUE;
    for(int i=1;i<=prices.length-1;i++){
        final int pre0=s0;
        final int pre1=s1;
        final int pre2=s2;
        s0=Math.max(pre0,pre2);
        s1=Math.max(pre0-prices[i],pre1);
        s2=pre1+prices[i];
    }
    return Math.max(s0,s2);
    }
}
// @lc code=end

