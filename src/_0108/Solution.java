package _0108;/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (67.63%)
 * Likes:    266
 * Dislikes: 0
 * Total Accepted:    37.3K
 * Total Submissions: 55.1K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
    public TreeNode sortedArrayToBST(final int[] nums) {
        if(nums.length == 0) return null;
        return bs(nums,0,nums.length-1);
    }
    public TreeNode bs(final int[] nums, final int left, final int right){
        
        if(left > right){
            return null;
        }
        final int mid = (left + right)/2;
        final TreeNode root = new TreeNode(nums[mid]);
        root.left = bs(nums,left,mid-1);
        root.right = bs(nums,mid+1,right);
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(final int x) { val = x; }
    }
}
// @lc code=end

