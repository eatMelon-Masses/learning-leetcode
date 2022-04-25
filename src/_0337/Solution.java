package _0337;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouye
 * @date 2022/3/30
 */
public class Solution {
    Map<TreeNode,Integer> g = new HashMap<TreeNode,Integer>();
    Map<TreeNode,Integer> f = new HashMap<TreeNode,Integer>();
    public int rob(TreeNode root) {
        if(null == root) return 0;
        rob(root.left);
        rob(root.right);
        int leftHalf = Math.max(g.getOrDefault(root.left,0) + g.getOrDefault(root.right,0),f.getOrDefault(root.left,0) + f.getOrDefault(root.right,0));
        int rightHalf = Math.max(g.getOrDefault(root.left,0) + f.getOrDefault(root.right,0), f.getOrDefault(root.left,0) + g.getOrDefault(root.right,0));
        f.put(root,Math.max(leftHalf,rightHalf));
        g.put(root,f.getOrDefault(root.left,0) + f.getOrDefault(root.right,0) + root.val);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rob(null);
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