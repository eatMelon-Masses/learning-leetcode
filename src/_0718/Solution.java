package _0718;/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 *
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * algorithms
 * Medium (47.29%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    6.3K
 * Total Submissions: 13.4K
 * Testcase Example:  '[1,2,3,2,1]\n[3,2,1,4,7]'
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释: 
 * 长度最长的公共子数组是 [3, 2, 1]。
 * 
 * 
 * 说明:
 * 
 * 
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 
 * 
 */

// @lc code=start
class Solution{ 
    public int findLength(final int[] A, final int[] B) {
        int max =0;
        int length = A.length;
        length = length +1;
        final int[][] dp = new int[length][length];
        for (int i = 0; i <= A.length-1 ; i++) {
            for (int j = 0; j <= B.length-1; j++) {
                //上一对元素也相等的情况下才进行累加
                final int tempResult=function(A, B,i,j);
                if ( dp[i][j]>0 && tempResult>0) {
                    dp[i + 1][j + 1] =tempResult+ dp[i][j];
                } else {
                    dp[i + 1][j + 1]=tempResult;
                }
                max =Math.max(max,dp[i+1][j+1]);

            }
        }
        return max;
    }

    /**
     *  判断x,y 坐标对应元素是否相等
     * @param a 数组A
     * @param b 数组B
     * @param x 坐标X
     * @param y 坐标Y
     * @return 相等1，不相等0
     */
    private int   function(final int[] a, final int[] b, final int x, final int y){
        if (x < 0 || y < 0) {
            return 0;
        }
        return (a[x] == b[y] ? 1 : 0);
    }
}
// @lc code=end

