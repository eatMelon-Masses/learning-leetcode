package array._0238;

import java.util.Arrays;

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int left = 1;
		int right = 1;
		int[] res = new int[n];
		Arrays.fill(res, 1);
		for (int i = 0; i < n; i++) {
			res[i] = res[i] * left;
			left = left * nums[i];

			res[n - i - 1] = res[n - i - 1] * right;
			right = right * nums[n - i - 1];
			System.out.println(left + "," + right);
			System.out.println(Arrays.toString(res));
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = new int[]{9, 0,2};
		solution.productExceptSelf(arr);
	}
}
