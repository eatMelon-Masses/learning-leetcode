package _0257;/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (60.64%)
 * Likes:    167
 * Dislikes: 0
 * Total Accepted:    18.6K
 * Total Submissions: 30.7K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(final TreeNode root) {
        if(root ==null) return new ArrayList<String>();
        return  dfs(root,new StringBuilder());
    }
    public List<String> dfs(final TreeNode root, final StringBuilder sb){
        final List<String> res = new ArrayList<String>();
        sb.append(root.val);
        if(root.left==null && root.right==null){
            res.add(sb.toString());
            return res;
        }
        if(root.left!=null){
            sb.append("->");
            res.addAll(dfs(root.left,sb));
            sb.delete(sb.length()-String.valueOf(root.left.val).length()-2,sb.length());
        }
        if(root.right!=null){
            sb.append("->");
            res.addAll(dfs(root.right,sb));
            sb.delete(sb.length()-String.valueOf(root.right.val).length()-2,sb.length());
        }
        return res;
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(final int x) { val = x; }
     }
}
// @lc code=end

