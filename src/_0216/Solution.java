package _0216;/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (69.03%)
 * Likes:    71
 * Dislikes: 0
 * Total Accepted:    10K
 * Total Submissions: 14.5K
 * Testcase Example:  '3\n7'
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    int n;
    int k;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(final int k, final int n) {
        final int [] bounds = new int[]{1,3,6,10,15,21,28,36,45};
        this.n = n;
        this.k = k;
        res = new ArrayList<List<Integer>>();
        if(n < bounds[k-1]) return res;
        dg(new ArrayList<Integer>(),0,1);
        return res;
    }
    public void dg(final ArrayList<Integer> cur, final int sum, final int start){
        //System.out.println("sum"+sum+",curList"+cur.toString());
        if(sum == n && cur.size()==k){
            res.add(cur);
            return;
        }
        if(sum >= n ||cur.size() >=k){
            return;
        }

        for(int i  = start;i<10;i++){
                final ArrayList<Integer> tempCur = new ArrayList<Integer>();
                tempCur.addAll(cur);
                tempCur.add(i);
                //System.out.println("i,"+i+"i,"+(i));
                dg(tempCur,sum+i,i+1);
        }
    }
}
// @lc code=end

