package __0101;/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (49.07%)
 * Likes:    499
 * Dislikes: 0
 * Total Accepted:    70.2K
 * Total Submissions: 143.1K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
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
class Solution {
    public boolean isSymmetric(final TreeNode root) {
        return isErrior(root,root);
    }
    boolean isErrior(final TreeNode left, final TreeNode right){
        if(left==null && right==null) return true;
        if(left==null||right==null) return false;
        return (left.val==right.val) && isErrior(left.left,right.right)
            && isErrior(left.right,right.left);
    }
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(final int x) { val = x; }
  }
}  
// @lc code=end

