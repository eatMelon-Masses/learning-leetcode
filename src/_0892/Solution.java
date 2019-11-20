package _0892;/*
 * @lc app=leetcode.cn id=892 lang=java
 *
 * [892] 三维形体的表面积
 *
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/description/
 *
 * algorithms
 * Easy (54.87%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    4K
 * Total Submissions: 7.3K
 * Testcase Example:  '[[2]]'
 *
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 
 * 请你返回最终形体的表面积。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[2]]
 * 输出：10
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 
 * 
 * 示例 4：
 * 
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 
 * 
 * 示例 5：
 * 
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 * 
 * 
 */

// @lc code=start
class Solution {
    public int surfaceArea(final int[][] grid) {
        int res = 0;
        for(int i = 0;i< grid.length;i++){
            for(int j=0;j< grid[i].length;j++){
                res +=sum(grid,i,j);
            }
        }
        return res;
    }
    public int sum(final int[][] grid, final int x, final int y){
        int sum = 0;
        final int cur = grid[x][y];
        final int up = x-1;
        int temp = 0;

        if(up>=0){
            temp = cur - grid[up][y]; 
            sum= (temp | 1 )>=0?(temp+sum): sum;
        }else{
            sum+=grid[x][y];
        }
        final int down = x+1;
        if(down < grid.length){
            temp = cur - grid[down][y];
            sum= (temp | 1 )>=0?(temp+sum): sum;
        }else{
            sum+=grid[x][y];
        }
        final int left = y-1;
        if(left >= 0 ){
            temp = cur -  grid[x][left];
            sum= (temp | 1 )>=0?(temp+sum): sum;           
        }else{
            sum+=grid[x][y];
        }
        final int right = y+1;
        if(right < grid[x].length){
            temp = cur - grid[x][right];
            sum= (temp | 1 )>=0?(temp+sum): sum;              
        }else{
            sum+=grid[x][y];
        }
        if(grid[x][y]>0) sum+=2;
        return sum;
    }
}
// @lc code=end

