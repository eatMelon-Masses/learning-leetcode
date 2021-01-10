package _0123;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 *
 *
 * 解题思路：由于我们最多可以完成两笔交易，因此任意一天结束后，我们会处于以下几种状态
 *  1.一次都没买
 *  2.买了一次
 *  3.进行了一次完整交易
 *  4.完整交易后又买了一笔
 *  5.完成两次交易
 *
 *  一次都没买收益为0
 *  买了一次buy1
 *  进行了一次完整交易sell1
 *  完成交易后又买了一笔buy2
 *  完成两次交易sell2
 *  对应的状态转移方程式为
 *  buy1[i] = max{buy1[i-1],-prices[i]}
 *  sell1[i] = max{sell1[i-1],prices[i]+buy1[i]}
 *  buy2[i] = max{buy2[i-1],sell1[i]-prices[i]}
 *  sell2[i] = max{sell2[i-1],buy2[i]+prices[i]}
 *  初始值
 *  buy1[0] = -prices[0]
 *  sell1[0] = 0
 *  buy2[0] = - prices[0]
 *  sell2[0] = 0
 *
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int[] buy1 = new int[prices.length];
        int[] sell1 = new int[prices.length];
        int[] buy2 = new int[prices.length];
        int[] sell2 = new int[prices.length];
        buy1[0] = -prices[0];
        sell1[0] = 0;
        buy2[0] = - prices[0];
        sell2[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1[i] = Math.max(buy1[i - 1], -prices[i]);
            sell1[i] = Math.max(sell1[i - 1], prices[i] + buy1[i]);
            buy2[i] = Math.max(buy2[i - 1], sell1[i] - prices[i]);
            sell2[i] = Math.max(sell2[i - 1], buy2[i] + prices[i]);
        }
        return Math.max(sell1[prices.length - 1], sell2[prices.length - 1]);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1};
        int result = solution.maxProfit(ints);
        System.out.println(result);
    }
}
