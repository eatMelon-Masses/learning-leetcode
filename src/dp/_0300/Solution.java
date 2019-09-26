package dp._0300;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        //Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        return dfs(nums, Integer.MIN_VALUE, 0, 0);
    }
    public int dfs(int[] nums, int pre,int start, int depth){
        if (start >= nums.length) {
            return depth;
        }
        int max = depth;
        for (int i = start; i < nums.length; i++) {
            int curr = nums[i];
            if (pre < curr) {
                max = Math.max(dfs(nums, curr, i + 1, depth + 1), max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(arr));

    }
}
