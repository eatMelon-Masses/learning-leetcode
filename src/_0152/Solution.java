package _0152;

/**
 * url: https://leetcode-cn.com/problems/maximum-product-subarray/
 * dp
 */
public class Solution {
        public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            int imax = 1;
            int imin = 1;
            for (int i = 0; i < nums.length; i++) {
                int e = nums[i];
                if (e < 0) {
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                imax = Math.max(e, imax * e);
                imin = Math.min(e, imin * e);
                max = Math.max(max, imax);
            }
            return max;
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-2, 0, -1};
        System.out.println(solution.maxProduct(arr));

    }
}
