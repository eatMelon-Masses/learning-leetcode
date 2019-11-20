package _0077;/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (71.05%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    24.8K
 * Total Submissions: 34.9K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(final int n, final int k) {
        this.result = new ArrayList<List<Integer>>();
        dg(1,new ArrayList<Integer>(),k,n);
        return result;
    }
    public void dg(final int curr, final ArrayList<Integer> combine, final int k, final int n){
        if(combine.size() == k){
            result.add((ArrayList<Integer>)combine.clone());
        }else{
            for(int i = curr;i<=n;i++){
            final ArrayList<Integer> tempList =(ArrayList<Integer>) combine.clone();
            tempList.add(i);
            dg(i+1,tempList,k,n);
            }
        }
        return;
    }
}
// @lc code=end

