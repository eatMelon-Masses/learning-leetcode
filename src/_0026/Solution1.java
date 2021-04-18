package _0026;

import java.util.Arrays;

/**
 * @author zhouye
 * @date 2021/4/18
 */
public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for (int i = p+1; i < nums.length; i++) {
            nums[p + 1] = nums[i];
            if (nums[p] != nums[p + 1]) {
                p++;
            }
        }
        System.out.println(Arrays.toString(nums));

        return p;
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int result = solution1.removeDuplicates(new int[]{1, 1, 2});
        System.out.println(result);
    }
}
