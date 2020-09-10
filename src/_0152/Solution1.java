package _0152;

public class Solution1 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        int max ;
        max=dpMax[0] = dpMin[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int node = nums[i];
            if (node>0){
                dpMax[i] = Math.max(node,dpMax[i-1] * node);
                dpMin[i] = Math.min(node,dpMin[i-1] * node);
            }else if(node<0){
                dpMax[i] = Math.max(node,dpMin[i-1] * node);
                dpMin[i] = Math.min(node,dpMax[i-1] * node);
            }else {
                dpMax[i] = 0;
                dpMin[i] = 0;
            }
            max = Math.max(max,dpMax[i]);
            System.out.println();
        }

        return max;
    }
    public static void main(String[] args) {

        Solution1 solution = new Solution1();
        int[] arr = {-2, 0, -1};
        System.out.println(solution.maxProduct(arr));
    }
}
