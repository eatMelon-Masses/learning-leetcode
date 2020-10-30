package _0129;

import javax.swing.tree.TreeNode;

public class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
         dg(root,0);
        return result;
        
    }

    public void dg(TreeNode root,int next) {
        if (root == null ) {

            result += next;
            return;
        }
        if (next == 0) {
            next = root.val;
        }else {
            int temp = root.val;

            do {
                next = next * 10;
                temp /= 10;
            }while (temp != 0);
            next+=root.val;
        }

        if (root.left != null) {

            dg(root.left, next);
        }
        if (root.right != null) {
            dg(root.right, next);

        }
        if (root.left == null && root.right == null) {
            result += next;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(13);
        root.right = new TreeNode(14);
        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(root));

    }
}


