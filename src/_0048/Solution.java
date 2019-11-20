package _0048;/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(final int[][] matrix) {
        int temp=0;
        final int length=matrix[0].length;
        if(length<2) return;
        for(int i=0;i<=length-1;i++){
            for(int j=i;j<=length-1;j++){
                temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
        int index=0;
        if(length%2!=0)
            index=(length-1)/2-1;
        else
            index=(length-1)/2;
        for(int j=0;j<=length-1;j++){
            for(int i=0;i<=index;i++){
                temp = matrix[j][length-1-i];
                matrix[j][length-1-i]=matrix[j][i];
                matrix[j][i]=temp;
            }
            
        }            

            
    }
   
}
// @lc code=end

