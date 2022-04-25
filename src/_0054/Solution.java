package _0054;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] visited = new int[n][m];
        int sum = matrix.length * matrix[0].length;

        List<Integer> result = new ArrayList<Integer>();
        int times = 0;
        while(result.size()<sum){
        int j = 0+times;
        int k = 0+times;
        int l = m-1-times;
        int ll = n-1-times;
           for(;j<m-times;j++){
               if(visited[k][j]++==0)
               result.add(matrix[k][j]);
           }
           j--;
           for(;k<n-times;k++){
               if(visited[k][j]++==0){
                result.add(matrix[k][j]);
               }
           }
           k--;
           for(;l>=0;l--){
               if(visited[k][l]++==0){
                result.add(matrix[k][l]);
               }
           }
           l++;
           for(;ll>=0;ll--){
               if(visited[ll][l]++==0){
                result.add(matrix[ll][l]);
               }
           }
           times++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}});
    }
}