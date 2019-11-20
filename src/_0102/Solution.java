package _0102;/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.64%)
 * Likes:    311
 * Dislikes: 0
 * Total Accepted:    58.3K
 * Total Submissions: 97.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class Solution {
    public List<List<Integer>> levelOrder(final TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        final List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while(!deque.isEmpty()){
            final List<TreeNode> tempList = new ArrayList<>();
            final List<Integer> nodeList = new ArrayList<>();
            for(final TreeNode node:deque){
            nodeList.add(node.val);
            if(node.left!=null) tempList.add(node.left);
            if(node.right!=null) tempList.add(node.right);
            }
            ans.add(nodeList);
            deque=new ArrayDeque<>(tempList);

        }
        return ans;
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(final int x) { val = x; }
      }
}
// @lc code=end

