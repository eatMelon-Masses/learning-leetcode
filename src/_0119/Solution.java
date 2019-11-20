package _0119;/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (59.02%)
 * Likes:    92
 * Dislikes: 0
 * Total Accepted:    29.4K
 * Total Submissions: 49.9K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> getRow(final int rowIndex) {
        final List<List<Integer>> resultList =generate(rowIndex+1);
        return resultList.get(rowIndex);
    }
    public List<List<Integer>> generate(final int numRows) {
      final List<List<Integer>> resultList = init(numRows);
      if(numRows<=2){
          return resultList;
      }
      for(int i =1;i<=resultList.size()-2;i++){
          final List<Integer> currList = resultList.get(i);
          final List<Integer> nextList =resultList.get(i+1);
          for(int j =1;j<=currList.size()-1;j++){
            final int currNum = calculate(currList,j-1)+calculate(currList,j);
            nextList.set(j,currNum);              
          }
      }
       return resultList; 
    }
    public int calculate(final List<Integer> list, final int index){
        return list.get(index);
    }
    public List<List<Integer>> init(final int numRows){
        final List<List<Integer>> list =new  ArrayList<List<Integer>>();
        for(int i = 1;i<=numRows;i++){
            final List<Integer> tempList =new ArrayList<Integer>();
            tempList.add(1);
            final int end =i-1;
            for(int j = 1;j<=end;j++){
                tempList.add(0);
            }
            tempList.set(end,1);
            list.add(tempList);
        }
        return list;
    }    
}
// @lc code=end

