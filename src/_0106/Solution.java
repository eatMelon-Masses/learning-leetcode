package _0106;/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (65.18%)
 * Likes:    126
 * Dislikes: 0
 * Total Accepted:    17.4K
 * Total Submissions: 26.6K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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

class Solution {
    int[] inorder=null;
    int[] postorder=null;
    Integer postIndex=-11;
    public TreeNode buildTree(final int[] inorder, final int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        this.postIndex=inorder.length-1;
        return dg(0,postIndex);
    }
    TreeNode dg(final int inorderStart, final int inorderEnd){
        if(inorderStart>inorderEnd) return null;
        final int rootVal=postorder[postIndex--];
        final int inorderRootIndex=findIndex(rootVal,inorder,inorderStart,inorderEnd);
        final TreeNode root = new TreeNode(rootVal);
        root.right=dg(inorderRootIndex+1,inorderEnd);
        root.left=dg(inorderStart,inorderRootIndex-1);

        return root;
    }
    int findIndex(final int target, final int[] array, int left, final int right){
        int ans =-12;
        for(;left<=right;left++){
            if(target==array[left]) ans=left;
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

