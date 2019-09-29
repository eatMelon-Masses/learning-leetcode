package _0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		if( len <4 ) return  res;
		Arrays.sort(nums);
		for (int i = 0; i < len - 3; i++) {
			//去重
			if(i>0 && nums[i] == nums[i-1]) continue;
			for (int j = i+1; j<len-2; j++) {
				//去重
				if(j>i+1 && nums[j] == nums[j-1]) continue;
				int left = j+1;
				int right = len-1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1]) left++;
						while (left < right && nums[right] == nums[right - 1]) right--;
						left++;
						right--;
					} else if(sum < target) left++;
					else right--;
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = new int[]{-1,0,-2, 0, 1, 2};
		System.out.println(solution.fourSum(arr,1));
	}

}
