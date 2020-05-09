package _0099;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * 通过次数16,674提交次数29,423
 * 在真实的面试中遇到过这道题？
 *
 */
public class Solution {
    //中序遍历上一次访问节点
    TreeNode pre = null;
    //每次中序遍历须设置第一个值的位置
    boolean firstNode = true;
    //本次中序遍历是否交换过数值，第一次默认是
    boolean sign = true;
    public void recoverTree(TreeNode root) {
        while(sign){
            sign = false;
            magic(root);
            pre = null;
            firstNode = true;
        }
    }
    public void magic(TreeNode root){
        if(root==null) return ;
        magic(root.left);
        if(firstNode){
            pre = root;
            firstNode = false;
        }
        if(pre!=null && pre.val > root.val){
            sign = true;
            int temp = pre.val;
            pre.val = root.val;
            root.val = temp;
        }
        pre = root;
        magic(root.right);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        solution.recoverTree(root);
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
