package _0501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int conut = 0;
    int p = 0;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> times = new ArrayList<>();
        dg(root, nums, times);

        System.out.println(Arrays.toString(nums.toArray()));
        System.out.println(Arrays.toString(times.toArray()));
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int e = nums.get(i);
            if (result.isEmpty()) {
                conut = times.get(i);
                result.add(e);
                continue;
            }
            if (conut < times.get(i)) {
                result.clear();
                result.add(e);
            } else if (conut == times.get(i)) {
                result.add(e);
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }
    public void dg(TreeNode root, ArrayList<Integer> temp,ArrayList<Integer> times){
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dg(root.left, temp,times);

        }
        if (!temp.isEmpty() && root.val == temp.get(temp.size()-1)) {
            times.add(times.remove(times.size() - 1) + 1);

        }else {
            temp.add(root.val);
            times.add(1);
        }
        p++;
        if (root.right != null) {
            dg(root.right, temp,times);

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution solution = new Solution();
        int[] mode = solution.findMode(root);
        System.out.println(Arrays.toString(mode));

    }

}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
