package _0200;/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (45.79%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    38.8K
 * Total Submissions: 84.6K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给定一个由 '1'（陆地）和
 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 
 * 输出: 3
 * 
 * 
 */

// @lc code=start
class Solution {
    char[][] grid;
    public int numIslands(final char[][] grid) {
        this.grid=grid;
        int sum = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0 ;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    sum++;
                    dg(i,j);
                }
            }
        }
        return sum;
        
    }
    //打标记
    public void dg(final int row, final int col){
        grid[row][col]='0';
        if(row-1>=0 && isLand(row-1,col)){
            dg(row-1,col);
        }
        if(row+1<=grid.length-1 && isLand(row+1,col)){
            dg(row+1,col);
        }
        if(col-1>=0 && isLand(row,col-1)){
            dg(row,col-1);
        }
        if(col+1<=grid[0].length-1 && isLand(row,col+1)){
            dg(row,col+1);
        }
    }
    public boolean isLand(final int row, final int col){
        return grid[row][col]=='1';
    }
}
// @lc code=end

