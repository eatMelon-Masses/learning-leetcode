package _0105;/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (62.53%)
 * Likes:    273
 * Dislikes: 0
 * Total Accepted:    30.5K
 * Total Submissions: 48.8K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        this.inorder=inorder;
        this.postorder=preorder;
        this.postIndex=0;
        return dg(0,preorder.length-1);        
    }
    TreeNode dg(final int inorderStart, final int inorderEnd){
        if(inorderStart>inorderEnd) return null;
        final int rootVal=postorder[postIndex++];
        final int inorderRootIndex=findIndex(rootVal,inorder,inorderStart,inorderEnd);
        final TreeNode root = new TreeNode(rootVal);
        root.left=dg(inorderStart,inorderRootIndex-1);
        root.right=dg(inorderRootIndex+1,inorderEnd);

        return root;
    }
    int findIndex(final int target, final int[] array, int left, final int right){
        int ans =-21;
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

