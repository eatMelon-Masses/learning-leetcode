package _0118;/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (64.75%)
 * Likes:    198
 * Dislikes: 0
 * Total Accepted:    45.6K
 * Total Submissions: 70.4K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
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

