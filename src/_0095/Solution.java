package _0095;/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 *
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
 *
 * algorithms
 * Medium (59.98%)
 * Likes:    224
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 23.5K
 * Testcase Example:  '3'
 *
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 
 * ⁠  1         3     3      2      1
 * ⁠   \       /     /      / \      \
 * ⁠    3     2     1      1   3      2
 * ⁠   /     /       \                 \
 * ⁠  2     1         2                 3
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<TreeNode> generateTrees(final int n) {
        final List<TreeNode> res = new ArrayList<TreeNode>();
        if(n==0)
            return res;
        else
            return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(final int start, final int end){
        final List<TreeNode> list = new ArrayList<TreeNode>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            for(final TreeNode l:generateTrees(start,i-1)){
                for(final TreeNode r:generateTrees(i+1,end)){
                    final TreeNode root = new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(final int x) { val = x; }
  }
// @lc code=end

