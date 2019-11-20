package _0120;/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 *
 * https://leetcode-cn.com/problems/triangle/description/
 *
 * algorithms
 * Medium (62.40%)
 * Likes:    249
 * Dislikes: 0
 * Total Accepted:    28.7K
 * Total Submissions: 46.1K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 * 
 * 
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
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

