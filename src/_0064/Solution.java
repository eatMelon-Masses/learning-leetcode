package _0064;/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (62.98%)
 * Likes:    317
 * Dislikes: 0
 * Total Accepted:    42K
 * Total Submissions: 66.6K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public static int minPathSum(final int[][] grid) {
        final int m=grid.length;
        final int n=grid[0].length;
        if(m==1&&n==1) return grid[0][0];
        if(m==1&&n==2) return grid[0][0]+grid[0][1];
        if(m==2&&n==1) return grid[0][0]+grid[1][0];
        final int[][] b =new int[m][n];

        b[0][0]=grid[0][0];
        for(int i=1;i<=n-1;i++){
            b[0][i]=b[0][i-1]+grid[0][i];

        }
        for(int i=1;i<=m-1;i++){
           b[i][0]=b[i-1][0]+grid[i][0];
        }
        for(int i=1;i<=m-1;i++){
            for(int j=1;j<=n-1;j++)
                b[i][j]=Math.min(b[i-1][j],b[i][j-1])+grid[i][j];
        }
        return b[m-1][n-1];
    }
}
// @lc code=end

